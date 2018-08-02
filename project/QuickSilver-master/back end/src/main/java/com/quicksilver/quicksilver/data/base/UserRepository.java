package com.quicksilver.quicksilver.data.base;

import com.quicksilver.quicksilver.models.User;

import java.util.List;

public interface UserRepository extends GenericRepository<User> {
    User findByUsername(String username);
}
