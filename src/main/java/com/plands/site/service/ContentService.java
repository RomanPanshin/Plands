package com.plands.site.service;

import com.plands.site.model.Content;
import com.plands.site.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ContentService {
    @Autowired
    private ContentRepository repository;

    public Content getContent(Long id) {
        return repository.findById(id).orElse(null);
    }
    public List<Content> getAllContent() {
        return repository.findAll();
    }

    public Content saveContent(Content content) {
        return repository.save(content);
    }

    public void deleteContent(Long id) {
        repository.deleteById(id);
    }
}
