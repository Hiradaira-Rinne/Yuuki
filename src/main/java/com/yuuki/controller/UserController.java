package com.yuuki.controller;

import com.yuuki.entity.User;
import com.yuuki.service.impl.UserServiceImpl;
import com.yuuki.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author heyang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @GetMapping("/api/v1/find")
    public User findById(@RequestParam(value = "id") Long id) {
            return userService.findById(id);
    }
}
