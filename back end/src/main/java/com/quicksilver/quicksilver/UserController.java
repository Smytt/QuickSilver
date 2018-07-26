package com.quicksilver.quicksilver;

import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
        System.out.println(user.getFavorites().size());
        return user;
    }

    @PostMapping(value = "/signup")
    @ResponseBody
    public User register(@RequestBody User user) {
        userService.register(user);
        return user;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return session.getAttribute("logged").toString();
    }

}
