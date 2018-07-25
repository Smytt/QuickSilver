package com.quicksilver.quicksilver;

import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable(name = "id") String id) {
        int parsedId = Integer.parseInt(id);
        return userService.getById(parsedId);
    }
}
