package com.example.plandsSite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/audit")
    public String audit(Model model) {
        // You can add attributes to the model if needed
        // model.addAttribute("attributeName", value);
        return "audit";  // This assumes you have an "audit.html" template in the templates folder
    }
}
