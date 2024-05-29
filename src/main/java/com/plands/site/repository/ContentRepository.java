package com.plands.site.repository;

import com.plands.site.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContentRepository extends JpaRepository<Content, Long> {
    Content findByKey(String key);
}
