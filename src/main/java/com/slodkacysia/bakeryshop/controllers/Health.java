package com.slodkacysia.bakeryshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Health {

    @RequestMapping("/health")
    public String healCheck(){

        return "health";
    }
}
