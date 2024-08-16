package com.plands.site.controller;

import com.plands.site.model.AuditCode;
import com.plands.site.model.User;
import com.plands.site.repository.AuditCodeRepository;
import com.plands.site.service.CodeGenerationService;
import com.plands.site.service.RconService;
import com.plands.site.service.UserService;
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
    private CodeGenerationService codeGenerationService;

    @Autowired
    private UserService userService;  // Use UserService

    @PostMapping("/add")
    public String addWhitelist(@RequestParam String playerName, @RequestParam String code, @RequestParam String email,
                               @RequestParam String password, Model model) {
        AuditCode auditCode = null;
        try {
            auditCode = auditCodeRepository.findByCode(code);
        } catch (IllegalArgumentException e) {
            model.addAttribute("status", "failure");
            return "audit";
        }

        if (auditCode == null || auditCode.isUsed()) {
            model.addAttribute("status", "failure");
            return "audit";
        }

        User user = userService.findByEmail(email);
        if (user == null) {
            // Register the user using UserService
            user = userService.registerUser(email, playerName, password);
        }

        // Add the user to the whitelist
        rconService.addWhitelist(playerName);

        // Mark the audit code as used and link it to the user
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
