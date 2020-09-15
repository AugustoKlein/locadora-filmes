package com.locadora.locadorafilmes.controllers;

import com.locadora.locadorafilmes.model.User;
import com.locadora.locadorafilmes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
