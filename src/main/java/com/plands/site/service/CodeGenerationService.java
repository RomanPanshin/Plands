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

    public UUID generateUniqueAuditCode(String password) {
        if (!authPassword.equals(password)) {
            return null;
        }

        UUID code = UUID.randomUUID();

        AuditCode newCode = new AuditCode();
        newCode.setCode(code);
        newCode.setUsed(false);

        auditCodeRepository.save(newCode);

        return code;
    }
}
