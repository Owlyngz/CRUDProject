package com.myproject.webshop.controller;

import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.model.User;
import com.myproject.webshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> allUsers() {
        return userService.getAllDTOUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO findById(@PathVariable Long id) { return userService.findById(id); }

    @PostMapping("/user")
    public List<UserDTO> saveMethod(@RequestBody User user) {
        return userService.saveMethod(user);
    }

    @DeleteMapping("/users/{id}")
    public List<UserDTO> deleteMethod(@PathVariable Long id) {
        return userService.deleteById(id);
    }

    @PutMapping("/users/{id}/put")
    public UserDTO updateMethod(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return userService.updateMethod(userDTO, id);
    }
}
