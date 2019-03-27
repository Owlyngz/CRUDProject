package com.myproject.webshop.services;

import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.mapper.UserMapper;
import com.myproject.webshop.model.User;
import com.myproject.webshop.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public List<UserDTO> getAllDTOUsers() {
        List<User> foundUsers = userRepository.findAllUsers();
        return userMapper.toDtoList(foundUsers);
    }


    public List<UserDTO> saveMethod(User user) {
        userRepository.save(user);
        return getAllDTOUsers();
    }


    public UserDTO findById(Long id) {

        UserDTO dto = userMapper.toDto(userRepository.findUserById(id));
        return dto;
    }

    public UserDTO updateMethod(UserDTO userDTO, Long id) {
        User foundUser = userRepository.findUserById(id);

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
        userRepository.deleteById(id);
        return getAllDTOUsers();
    }

}

//CRUD - create(save), read(find), update, delete
