package com.sys.queue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/"})
    public String home() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "Auth/login";
    }

    @GetMapping("/table")
    public String getTablePage(Model model) {
        model.addAttribute("title", "Queue List - Tables");
        return "QueueOfficeDisplay/table";  // Returns the 'table.html' template
    }
}
