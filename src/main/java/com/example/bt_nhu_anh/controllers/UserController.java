package com.example.bt_nhu_anh.controllers;

import com.example.bt_nhu_anh.models.User;
import com.example.bt_nhu_anh.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServices userServices;
    @GetMapping("")
    public Iterable<User> showAllUser(){
        return  userServices.findAll();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        userServices.save(user);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userServices.update(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userServices.remove(id);
    }


}
