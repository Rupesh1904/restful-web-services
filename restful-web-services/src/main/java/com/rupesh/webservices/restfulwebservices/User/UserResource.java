package com.rupesh.webservices.restfulwebservices.User;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    private UserDaoSource service;

    public UserResource(UserDaoSource service){
        this.service= service;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id ){
        return service.findOne(id);
    }
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.save(user);
    }
}