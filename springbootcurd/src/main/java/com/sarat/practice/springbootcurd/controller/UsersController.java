package com.sarat.practice.springbootcurd.controller;

import com.sarat.practice.springbootcurd.model.Users;
import com.sarat.practice.springbootcurd.repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJPARepository userJPARepository;

    @GetMapping(value = "/all")
    public List<Users> findAllUsers(){
        return userJPARepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name){
        return userJPARepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users){
        userJPARepository.save(users);
        return userJPARepository.findByName(users.getName());
    }
}
