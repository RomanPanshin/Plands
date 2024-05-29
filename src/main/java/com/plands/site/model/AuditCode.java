package com.example.plandsSite.Model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class AuditCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID code;
    private boolean used;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "AuditCode{" +
                "id=" + id +
                ", code=" + code +
                ", used=" + used +
                '}';
    }
}
