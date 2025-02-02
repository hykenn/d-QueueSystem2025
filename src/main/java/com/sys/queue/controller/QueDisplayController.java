package com.sys.queue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QueDisplayController {
    
    @GetMapping("/queuedisplay")
    public String queuedisplay() {
        return "QueueDisplay/queuedisplay";
    }

}
