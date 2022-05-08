package com.slodkacysia.bakeryshop.controllers;

import com.slodkacysia.bakeryshop.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
