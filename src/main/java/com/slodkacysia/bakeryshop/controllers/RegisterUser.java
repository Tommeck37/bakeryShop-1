package com.slodkacysia.bakeryshop.controllers;

import com.slodkacysia.bakeryshop.entity.User;
import com.slodkacysia.bakeryshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterUser {

    private final UserRepository userRepository;

    @Autowired
    private RegisterUser(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping("/register")
    public String registerUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "registerUser";
    }
    @PostMapping("/register")
    public String addUser(@Valid@ ModelAttribute User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "registerUser";
        }else{
            List<User> userList = userRepository.getAllBy();

            for (User userInList : userList) {

                if (userInList.getEmail().equals(user.getEmail())) {
                    model.addAttribute("emailMsg","Taki email już istnieje");
                    return "registerUser";
                }


            }
            userRepository.save(user);
            return "redirect:/health";
        }
    }
}
