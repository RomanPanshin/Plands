package com.plands.site.repository;

import com.plands.site.model.AuditCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditCodeRepository extends JpaRepository<AuditCode, UUID> {
    AuditCode findByCode(UUID code);
}
