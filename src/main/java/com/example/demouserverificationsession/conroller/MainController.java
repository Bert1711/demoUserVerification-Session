package com.example.demouserverificationsession.conroller;

import com.example.demouserverificationsession.service.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }
    @GetMapping("/main")
    public String home() {
        String username = loggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
        }
        return "main.html";
    }
}
