
package com.example.plandsSite.Controller;

import com.example.plandsSite.Model.AuditCode;
import com.example.plandsSite.Repository.AuditCodeRepository;
import com.example.plandsSite.Service.CodeGenerationService;
import com.example.plandsSite.Service.RconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    @PostMapping("/add")
    public String addWhitelist(@RequestParam String playerName, @RequestParam String code, Model model) { // Note that we changed UUID to String for the code parameter
        AuditCode auditCode = null;
        try {
            UUID codeUUID = UUID.fromString(code);
            auditCode = auditCodeRepository.findByCode(codeUUID);
        } catch (IllegalArgumentException e) {
            model.addAttribute("status", "failure");
            return "audit";
        }

        if(auditCode == null || auditCode.isUsed()) {
            model.addAttribute("status", "failure");
            return "audit";
        }

        rconService.addWhitelist(playerName);
        auditCode.setUsed(true);
        auditCodeRepository.save(auditCode);
        model.addAttribute("status", "success");
        return "audit";
    }


    @PostMapping("/generate")
    public ResponseEntity<String> generateAuditCode(@RequestParam String password) {
        UUID newCode = codeGenerationService.generateUniqueAuditCode(password);

        if (newCode == null) {
            return ResponseEntity.badRequest().body("Incorrect password");
        }

        return ResponseEntity.ok("Generated Audit Code: " + newCode);
    }
}

