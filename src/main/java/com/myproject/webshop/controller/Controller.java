package com.myproject.webshop.controller;

import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.myproject.webshop.services.Service;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/users")
    public List<UserDTO> allUsers() {
        return service.getAllDTOUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping("/user/")
    public List<UserDTO> saveMethod(@RequestBody User user) {
        return service.saveMethod(user);
    }

    @DeleteMapping("/users/{id}")
    public List<UserDTO> deleteMethod(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/users/{id}/put")
    public UserDTO updateMethod(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return service.updateMethod(userDTO, id);
    }


}
