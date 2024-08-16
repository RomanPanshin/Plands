package com.plands.site.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
public class AuditCode {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(columnDefinition = "CHAR(36)")
    private String code;

    private boolean used;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AuditCode{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", used=" + used +
                ", user=" + user +
                '}';
    }
}

