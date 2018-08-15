package com.quicksilver.quicksilver;

import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable(name = "id") int id) {
        User user = userService.findById(id);
        return user;
    }

    @PostMapping(value = "/favorites/add")
    public void addToFav(@RequestBody HashMap<String, Integer> obj) {
        Integer userId = obj.get("user");
        Integer movieId = obj.get("movie");
        userService.addToFav(userId, movieId);
    }

    @PostMapping(value = "/favorites/remove")
    public void removeFromFav(@RequestBody HashMap<String, Integer> obj) {
        Integer userId = obj.get("user");
        Integer movieId = obj.get("movie");
        userService.removeFromFav(userId, movieId);
    }


    @PostMapping(value = "/register")
    @ResponseBody
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public User login(@RequestBody User user) {
        return userService.findByUsername(user);
    }



}
