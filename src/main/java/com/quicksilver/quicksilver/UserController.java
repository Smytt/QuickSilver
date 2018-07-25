package com.quicksilver.quicksilver;

import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

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

    @PostMapping(value = "/signup")
    @ResponseBody
    public User register(@RequestBody User user) {
        userService.register(user);
        return user;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public void login(@RequestBody User user) {
        userService.login(user);
    }
}
