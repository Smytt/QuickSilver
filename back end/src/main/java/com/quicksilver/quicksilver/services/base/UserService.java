package com.quicksilver.quicksilver.services.base;

import com.quicksilver.quicksilver.models.User;

public interface UserService {
    User findById (int id);

    void register(User user);

    User login(User user);
}
