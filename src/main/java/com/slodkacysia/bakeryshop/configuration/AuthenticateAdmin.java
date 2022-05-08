package com.slodkacysia.bakeryshop.configuration;

import com.slodkacysia.bakeryshop.entity.User;
import com.slodkacysia.bakeryshop.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateAdmin {

    private  final UserRepository userRepository;
    @Autowired
    public AuthenticateAdmin(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean isAuthenticated(String email, String password) {
        boolean isAuthenticated = false;
        if (email.equals("tomasz.czornak59@gmail.com")) {
            User user = userRepository.getUserByEmail(email);
            String hashedPass = user.getPassword();
            isAuthenticated = BCrypt.checkpw(password, hashedPass);

        }
        return isAuthenticated;
    }
}