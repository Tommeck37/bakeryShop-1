package com.slodkacysia.bakeryshop.service;

import com.slodkacysia.bakeryshop.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
