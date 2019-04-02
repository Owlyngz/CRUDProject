package com.myproject.webshop.itemtest;

import com.myproject.webshop.model.Item;
import com.myproject.webshop.repositories.ItemRepository;
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
public class ItemRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ItemRepository items;

    @Test
    public void testFindItemByQuantity() {

        Item item = new Item(89L,"desc", 83, "name", "type", 39, "panasonic", 96);
        entityManager.persist(item);
        entityManager.flush();

        Item found = (Item) items.findItemsQuantity(item.getQuantity());

//        Assert.assertThat(found.getQuantity(96)).isEqualTo(item.getQuantity());
        Assert.assertEquals(item, found);
    }

    @Test
    public void testFindById() {

        Item item = new Item(90L,"desc", 83, "name", "type", 39, "panasonic", 96);
        entityManager.persist(item);
        entityManager.flush();

        Item found = items.findItemById(90L);
        Assert.assertEquals(item, found);

    }
}
