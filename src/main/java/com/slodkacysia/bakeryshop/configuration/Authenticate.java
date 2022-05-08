package com.slodkacysia.bakeryshop.configuration;

import com.slodkacysia.bakeryshop.entity.User;
import com.slodkacysia.bakeryshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Authenticate {

    @Autowired
    UserRepository userRepository;


    public boolean isAuthenticated(String email, String password){
        boolean isAuthenticated = false;
        User user = userRepository.getUserByEmail(email);
        String hashedPass = user.getPassword();
        isAuthenticated = BCrypt.checkpw(password,hashedPass);

        return isAuthenticated;
    }
}
