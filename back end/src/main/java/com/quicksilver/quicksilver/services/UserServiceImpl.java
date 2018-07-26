package com.quicksilver.quicksilver.services;

import com.quicksilver.quicksilver.data.base.GenericRepository;
import com.quicksilver.quicksilver.data.base.UserRepository;
import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository genericRepository) {
        this.userRepository = genericRepository;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void register(User user) {
        userRepository.create(user);
    }

    @Override
    public User login(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if(Objects.equals(dbUser.getPassword(), user.getPassword())) {
            System.out.println("logged");
        }

        return dbUser;
    }
}
