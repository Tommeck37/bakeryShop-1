package com.slodkacysia.bakeryshop.controllers;

import com.slodkacysia.bakeryshop.configuration.Authenticate;
import com.slodkacysia.bakeryshop.entity.User;
import com.slodkacysia.bakeryshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Authenticate authenticate;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userRepository.getUserByEmail(email);
        if(authenticate.isAuthenticated(email,password)) {
            return "redirect:/welcome";
        }
        return "redirect:/login?error";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value="error", required = false)
            String error,
            @RequestParam(value="logout", required = false)
            String logout,
            Model model){

        if(error != null){
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout !=null){
            model.addAttribute("msg", "You have been logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = {
            "/",
            "/welcome"
    }, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
