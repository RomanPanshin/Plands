package com.plands.site.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nlogin") // Map to the 'nlogin' table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ai") // Map to the 'ai' column
    private Long id;

    @Column(name = "last_name", nullable = false) // Map 'nickname' to the 'last_name' column
    private String nickname;

    @Column(name = "unique_id", length = 32)
    private String uniqueId;

    @Column(name = "mojang_id", length = 32, unique = true)
    private String mojangId;

    @Column(name = "bedrock_id", length = 32, unique = true)
    private String bedrockId;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "last_ip", length = 60)
    private String lastIp = "127.0.0.1";

    @Column(name = "last_seen", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp lastSeen;

    @Column(name = "creation_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp creationDate;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "discord", length = 255)
    private String discord;

    @Column(name = "settings", columnDefinition = "TEXT")
    private String settings;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getMojangId() {
        return mojangId;
    }

    public void setMojangId(String mojangId) {
        this.mojangId = mojangId;
    }

    public String getBedrockId() {
        return bedrockId;
    }

    public void setBedrockId(String bedrockId) {
        this.bedrockId = bedrockId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public java.sql.Timestamp getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(java.sql.Timestamp lastSeen) {
        this.lastSeen = lastSeen;
    }

    public java.sql.Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.sql.Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscord() {
        return discord;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", mojangId='" + mojangId + '\'' +
                ", bedrockId='" + bedrockId + '\'' +
                ", password='" + password + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastSeen=" + lastSeen +
                ", creationDate=" + creationDate +
                ", email='" + email + '\'' +
                ", discord='" + discord + '\'' +
                ", settings='" + settings + '\'' +
                '}';
    }
}
