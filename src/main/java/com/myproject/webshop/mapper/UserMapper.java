package com.myproject.webshop.mapper;


import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDTO toDto(User user) {

        return new UserDTO(user.getId(), user.getUserName(), user.getUserSurname(), user.getUserEmail(), user.getPassword());

    }


    public List<UserDTO> toDtoList(List<User> users) {

        List<UserDTO> userDTO = new ArrayList<>();

        for (User user : users) {
            userDTO.add(toDto(user));
        }
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getUserName(), userDTO.getUserSurname(), userDTO.getUserEmail(), userDTO.getPassword());
    }


    public List<User> toEntityList(List<UserDTO> userDTOList) {

        List<User> entityList = new ArrayList();

        for (UserDTO userDTO : userDTOList) {

            entityList.add(toEntity(userDTO));
        }
        return entityList;

    }

    public User updateUser(UserDTO userDTO, User user) {

        user.setUserName(userDTO.getUserName());
        user.setUserSurname(userDTO.getUserSurname());
        user.setPassword(userDTO.getPassword());
        user.setUserEmail(userDTO.getUserEmail());

        return user;
    }

}
