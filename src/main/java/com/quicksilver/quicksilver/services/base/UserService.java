package com.quicksilver.quicksilver.services.base;

import com.quicksilver.quicksilver.models.User;

public interface UserService {
    User getById(int id);

    void register(User user);

    void login(User user);
}
