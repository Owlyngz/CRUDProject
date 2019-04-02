package com.myproject.webshop.usertest;

import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.mapper.UserMapper;
import com.myproject.webshop.model.User;
import com.myproject.webshop.repositories.UserRepository;
import com.myproject.webshop.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;


@RunWith(MockitoJUnitRunner.class)
public class UserUserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    UserService userService;

    @Before
    public void setUp() {
        userMapper = new UserMapper();
        userService = new UserService(userRepository, userMapper);

        User user = new User();
        user.setUserName("Gvido");
        user.setUserSurname("Francuzov");
        user.setUserEmail("moj@email.ru");

        User user1 = new User();
        user1.setUserName("Mother");
        user1.setUserSurname("Nature");
        user1.setUserEmail("Email");
        user1.setId(15L);

        User user2 = new User();
        user2.setUserName("Olya");
        user2.setUserSurname("Babanova");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);


        Mockito.when(userRepository.findAllUsers()).thenReturn(users);
        Mockito.when(userRepository.findUserById(anyLong())).thenReturn(user1);
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user2);

        Mockito.doNothing().when(userRepository).deleteById(anyLong());

    }

    @Test
    public void saveMethodTest() {

        User user = new User();

        List<UserDTO> savedDTO = userService.saveMethod(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);

    }

    @Test
    public void updateMethodTest() {

        UserDTO userDTO = new UserDTO(15L, "name", "lastname", "email", "pw123");

        UserDTO updatedDTO = userService.updateMethod(userDTO, 15L);
        Long expected = 15L;

        Assert.assertEquals(expected, updatedDTO.getId());

    }

    @Test
    public void deleteByIdTest() {

        List<UserDTO> deletedDtosId = userService.deleteById(3l);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(3L);

    }

    @Test
    public void findByIdTest() {

        UserDTO dto = userService.findById(777L);

        Assert.assertEquals("Mother", dto.getUserName());
        Assert.assertEquals("Nature", dto.getUserSurname());
        Assert.assertEquals("Email", dto.getUserEmail());
    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteByIdNotNULL() {

        List<UserDTO> deletedDtosId = userService.deleteById(null);

    }

    @Test(expected = HttpClientErrorException.class)
    public void deletedBy0Id() {

        try {
            userService.deleteById(0L);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.I_AM_A_TEAPOT, e.getStatusCode());
            throw e;
        }
    }
}
