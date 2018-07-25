package com.quicksilver.quicksilver.services;

import com.quicksilver.quicksilver.data.UserRepository;
import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void register(User user) {
        userRepository.create(user);
    }

    @Override
    public void login(User user) {
        User dbUser = userRepository.getByUsername(user.getUsername());
        if(Objects.equals(dbUser.getPassword(), user.getPassword())) {
            System.out.println("logged");
        }
    }
}
