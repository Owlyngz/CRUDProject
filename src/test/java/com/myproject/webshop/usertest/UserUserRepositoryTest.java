package com.myproject.webshop.usertest;


import com.myproject.webshop.model.User;
import com.myproject.webshop.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@Ignore
public class UserUserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;

    @Test
    public void testFindByLastName() {
        User user = new User(13L, "name","lastname", "Email", "passWORD222");
        entityManager.persist(user);
    }

    @Test
    public void testSearchById() {

        User user = new User(13L, "name","lastname", "Email", "passWORD222");

        entityManager.persist(users);
        entityManager.flush();

        User found = users.findUserById(13L);
        Assert.assertEquals(user, found);

    }

    private User createCustomer() {
        return new User(8L, "name", "lastname", "email", "pw333");
    }
}


