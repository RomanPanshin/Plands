package com.plands.site.repository;

import com.plands.site.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByNickname(String nickname); // You might want to remove this if "nickname" is no longer part of the entity.
    User findByMojangId(String mojangId);
    User findByBedrockId(String bedrockId);
}
