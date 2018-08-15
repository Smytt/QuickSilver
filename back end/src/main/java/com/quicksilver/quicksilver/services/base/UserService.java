package com.quicksilver.quicksilver.services.base;

import com.quicksilver.quicksilver.models.User;

public interface UserService {
    User findById (int id);

    User register(User user);

    User findByUsername(User user);

    void addToFav(Integer userId, Integer movieId);

    void removeFromFav(Integer userId, Integer movieId);
}
