package com.quicksilver.quicksilver.data;

import com.quicksilver.quicksilver.models.User;

public interface UserRepository {
    User getById(int id);
}