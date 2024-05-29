package com.plands.site.controller;

import com.plands.site.model.Content;
import com.plands.site.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ContentService contentService;

    @GetMapping("/content")
    public String listContent(Model model) {
        model.addAttribute("contents", contentService.getAllContent());
        return "admin/content-list";
    }

    @GetMapping("/content/edit/{id}")
    public String editContent(@PathVariable Long id, Model model) {
        Content content = contentService.getContent(id);
        if (content == null) {
            // Handle the case where content with the given id does not exist
            return "redirect:/admin/content";
        }
        model.addAttribute("content", content);
        return "admin/content-edit";
    }

    @PostMapping("/content/save")
    public String saveContent(@ModelAttribute Content content) {
        contentService.saveContent(content);
        return "redirect:/admin/content";
    }

    @GetMapping("/content/delete/{id}")
    public String deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return "redirect:/admin/content";
    }
}