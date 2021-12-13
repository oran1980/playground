package com.playground.playground.springboot.webservices.restful.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    // GET /users
    // retrieveAllUsers
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers () {
        return userDaoService.findAll();
    }

    // GET /users/{id}
    // retrieveUser(int id)
    @GetMapping(path = "/users/{id}")
    public User retrieveUser (@PathVariable int id) {
        return userDaoService.findOne(id);
    }
}
