package com.example.udemyCourse.springBoot.Controller;

import com.example.udemyCourse.springBoot.Entity.User;
import com.example.udemyCourse.springBoot.Exception.UserNotFoundException;
import com.example.udemyCourse.springBoot.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //GET /users/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user= service.find0ne(id);
        if(user==null){
            throw new UserNotFoundException("id "+id+" not found");
        }
        return user;
    }
    @PostMapping("/users")
    public  void createUser(@RequestBody User user){
        User savedUser= service.save(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user=service.deleteById(id);
        if(user==null){
            throw new UserNotFoundException("id"+id+" not found");
        }

    }
}
