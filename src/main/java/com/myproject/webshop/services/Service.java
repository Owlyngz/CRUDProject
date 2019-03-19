package com.myproject.webshop.services;

import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.mapper.UserMapper;
import com.myproject.webshop.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import com.myproject.webshop.repositories.Repository;

import java.util.List;

@Component
public class Service {

    private final Repository repository;
    private final UserMapper userMapper;

    public Service(Repository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }


    public List<UserDTO> getAllDTOUsers() {
        List<User> foundUsers = repository.findAllUsers();
        return userMapper.toDtoList(foundUsers);
    }


    public List<UserDTO> saveMethod(User user) {
        repository.save(user);
        return getAllDTOUsers();
    }


    public UserDTO findById(Long id) {

        UserDTO dto = userMapper.toDto(repository.findUserById(id));
        return dto;
    }

    public UserDTO updateMethod(UserDTO userDTO, Long id) {
        User foundUser = repository.findUserById(id);

        userMapper.updateUser(userDTO, foundUser);

        saveMethod(foundUser);

        return findById(id);

    }

    public List<UserDTO> deleteById(Long id) {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.LOCKED);
        }
        if (id == 0) {
            throw new HttpClientErrorException(HttpStatus.I_AM_A_TEAPOT);
        }
        repository.deleteById(id);
        return getAllDTOUsers();
    }


    //CRUD - create(save), read(find), update, delete


}