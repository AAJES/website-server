package com.ajes.controller;

import com.ajes.model.User;
import com.ajes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajes")
@CrossOrigin("https://project-client-kappa.vercel.app/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody() User user){
        return userService.addUser(user);
    }

    @GetMapping("/user")
    public List<User> getAlluser(){
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public User getById(@PathVariable() Integer userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/user/{userId}")
    public User deleteById(@PathVariable() Integer userId){
        return userService.deleteUserById(userId);
    }

    @PutMapping("/user/{userId}")
    public User updateById(@RequestBody() User user,@PathVariable() Integer userId){
        return userService.updateUserById(userId,user);
    }
    @GetMapping("/user/{userName}")
    public User getById(@PathVariable() String userName){

        return userService.getUserByUserName(userName);
    }


}
