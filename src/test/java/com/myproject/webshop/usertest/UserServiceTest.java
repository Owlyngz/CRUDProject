package com.myproject.webshop.usertest;

import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.mapper.UserMapper;
import com.myproject.webshop.model.User;
import com.myproject.webshop.repositories.Repository;
import com.myproject.webshop.services.Service;
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
public class UserServiceTest {


    //private Service service;
    @Mock
    private Repository repository;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    Service service;

    @Before
    public void setUp() {
     userMapper = new UserMapper();
        service = new Service(repository, userMapper);

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


        Mockito.when(repository.findAllUsers()).thenReturn(users);
        Mockito.when(repository.findUserById(anyLong())).thenReturn(user1);
        Mockito.when(repository.save(any(User.class))).thenReturn(user2);

        Mockito.doNothing().when(repository).deleteById(anyLong());


    }

    @Test
    public void saveMethodTest() {

        User user = new User();

        List<UserDTO> savedDTO = service.saveMethod(user);

        //Mockito.verify(repository.save(user), Mockito.times(1));
        Mockito.verify(repository, Mockito.times(1)).save(user);

    }

    @Test
    public void updateMethodTest() {

//        service.updateMethod(user, 11L);

        UserDTO userDTO = new UserDTO(45L, "name", "lastname", "email", "pw123");

        UserDTO updatedDTO = service.updateMethod(userDTO, 15L);
        Long expected = 15L;

        Assert.assertEquals(expected,  updatedDTO.getId());

    }

    @Test
    public void deleteByIdTest() {

        List<UserDTO> deletedDtosId = service.deleteById(3l);

        Mockito.verify(repository, Mockito.times(1)).deleteById(3L);

    }

    @Test
    public void findByIdTest() {

        UserDTO dto = service.findById(777L);

        Assert.assertEquals("Mother", dto.getUserName());
        Assert.assertEquals("Nature", dto.getUserSurname());
        Assert.assertEquals("Email", dto.getUserEmail());
    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteByIdNotNULL() {

        List<UserDTO> deletedDtosId = service.deleteById(null);

        Mockito.verify(repository, Mockito.times(1)).deleteById(null);
    }

    @Test(expected = HttpClientErrorException.class)
    public void deletedBy0Id() {

        try {
            service.deleteById(0L);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.I_AM_A_TEAPOT, e.getStatusCode());
            throw e;
        }
    }
}
