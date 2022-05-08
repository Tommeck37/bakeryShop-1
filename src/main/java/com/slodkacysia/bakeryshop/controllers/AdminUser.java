package com.slodkacysia.bakeryshop.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminUser {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "adminLogin";
    }

}
