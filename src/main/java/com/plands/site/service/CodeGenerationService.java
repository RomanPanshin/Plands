package com.plands.site.service;

import com.plands.site.model.AuditCode;
import com.plands.site.repository.AuditCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CodeGenerationService {

    @Autowired
    private AuditCodeRepository auditCodeRepository;

    // Fetch the password from application.properties
    @Value("${code.generation.password}")
    private String authPassword;

    public synchronized UUID generateUniqueAuditCode(String password) {
        if (authPassword.equals(password)) {
            UUID newCode;
            boolean isUnique = false;
            int attempts = 0;

            do {
                newCode = UUID.randomUUID();
                if (auditCodeRepository.findByCode(newCode.toString()) == null) {
                    isUnique = true;
                }
                attempts++;
            } while (!isUnique && attempts < 10);

            if (!isUnique) {
                return null;
            }

            return newCode;
        }
        return null;
    }

    public AuditCode createAuditCode(UUID newCode) {
        AuditCode auditCode = new AuditCode();
        auditCode.setCode(newCode.toString());
        auditCode.setUsed(false);
        auditCodeRepository.save(auditCode);
        return auditCode;
    }
}
