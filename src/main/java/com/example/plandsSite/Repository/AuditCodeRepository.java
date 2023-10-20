package com.example.plandsSite.Repository;

import com.example.plandsSite.Model.AuditCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditCodeRepository extends JpaRepository<AuditCode, UUID> {
    AuditCode findByCode(UUID code);
}
