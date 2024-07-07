package com.plands.site.controller;

import com.plands.site.model.AuditCode;
import com.plands.site.model.User;
import com.plands.site.repository.AuditCodeRepository;
import com.plands.site.repository.UserRepository;
import com.plands.site.service.CodeGenerationService;
import com.plands.site.service.RconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/whitelist")
public class AuditController {

    @Autowired
    private RconService rconService;

    @Autowired
    private AuditCodeRepository auditCodeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CodeGenerationService codeGenerationService;

    @PostMapping("/add")
    public String addWhitelist(@RequestParam String playerName, @RequestParam String code, @RequestParam String email, Model model) {
        AuditCode auditCode = null;
        try {
            UUID codeUUID = UUID.fromString(code);
            auditCode = auditCodeRepository.findByCode(codeUUID);
        } catch (IllegalArgumentException e) {
            model.addAttribute("status", "failure");
            return "audit";
        }

        if (auditCode == null || auditCode.isUsed()) {
            model.addAttribute("status", "failure");
            return "audit";
        }

        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setNickname(playerName);
            user = userRepository.save(user);
        }

        rconService.addWhitelist(playerName);
        auditCode.setUsed(true);
        auditCode.setUser(user);
        auditCodeRepository.save(auditCode);

        model.addAttribute("status", "success");
        return "audit";
    }

    @Transactional
    @PostMapping("/generate")
    public ResponseEntity<String> generateAuditCode(@RequestParam String password) {
        UUID newCode = codeGenerationService.generateUniqueAuditCode(password);

        if (newCode == null) {
            return ResponseEntity.badRequest().body("Could not generate a unique code. Please try again.");
        }

        // Create and save the new audit code
        AuditCode auditCode = codeGenerationService.createAuditCode(newCode);

        return ResponseEntity.ok("Generated Audit Code: " + newCode);
    }
}
