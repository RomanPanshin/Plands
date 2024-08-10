package com.plands.site.controller;

import com.plands.site.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private ContentService contentService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("contents", contentService.getAllContent());
        return "index";
    }

    @GetMapping("/donate")
    public String donate(Model model) {
//        model.addAttribute("contents", contentService.getAllContent());
        return "donate";
    }

    @GetMapping("/audit")
    public String audit(Model model) {
        // You can add attributes to the model if needed
        // model.addAttribute("attributeName", value);
        return "audit";  // This assumes you have an "audit.html" template in the templates folder
    }
}
