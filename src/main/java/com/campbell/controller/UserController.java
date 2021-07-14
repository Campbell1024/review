package com.campbell.controller;

import com.campbell.entity.User;
import com.campbell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Campbell
 * @date 2021/7/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/update")
    public Boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/delete")
    public Boolean deleteUserById(@RequestParam("id") Integer id) {
        return userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/get")
    public List<User> getUserListByIds(@RequestBody List<Integer> ids) {
        return userService.getUserListByIds(ids);
    }

}
