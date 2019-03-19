package com.myproject.webshop.itemtest;

import com.myproject.webshop.dto.ItemDto;
import com.myproject.webshop.mapper.ItemMapper;
import com.myproject.webshop.model.Item;
import com.myproject.webshop.repositories.ItemRepository;
import com.myproject.webshop.repositories.Repository;
import com.myproject.webshop.services.ItemService;
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
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ItemMapper itemMapper;

    @InjectMocks
    ItemService itemService;

    @Before
    public void setUp() {

        itemMapper = new ItemMapper();

        itemService = new ItemService(itemRepository, itemMapper);

        Item item = new Item();
        item.setDescription("comfortable");
        item.setPrice("199.99$");
        item.setId(29L);

        Item item1 = new Item();
        item1.setDescription("gorgeous");
        item1.setPrice("800$");
        item1.setId(88L);

        List<Item>items = new ArrayList<>();
        items.add(item);
        items.add(item1);

        Mockito.when(itemRepository.findAllItems()).thenReturn(items);
        Mockito.when(itemRepository.findItemById(anyLong())).thenReturn(item);
        Mockito.when(itemRepository.save(any(Item.class))).thenReturn(item1);

        Mockito.doNothing().when(itemRepository).deleteById(anyLong());


    }

    @Test
    public void saveItemTest() {

        Item item = new Item();

        List<ItemDto> savedDto = itemService.saveItem(item);

        Mockito.verify(itemRepository, Mockito.times(1)).save(item);

    }

    @Test
    public void updateItemTest() {

        ItemDto itemDto = new ItemDto(666L, "crap", "0.99$");

        ItemDto updatedItem = itemService.updateItem(itemDto, 29L);

        Long expected = 29L;

        Assert.assertEquals(expected, updatedItem.getId());
    }

    @Test
    public void deleteByIdItem() {

        List<ItemDto> deletedDtoItemId = itemService.deleteItemById(888L);

        Mockito.verify(itemRepository, Mockito.times(1)).deleteById(888L);
    }

    @Test
    public void findItemById() {

        ItemDto dto = itemService.findItemById(35L);

        Assert.assertEquals("comfortable", dto.getDescription());
        Assert.assertEquals("199.99$", dto.getPrice());

    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteByIdNotNull() {

        List<ItemDto> deletedDtosId = itemService.deleteItemById(null);

        Mockito.verify(itemRepository, Mockito.times(1)).deleteById(null);

    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteBy0Test() {

        try {
            itemService.deleteItemById(0L);
        }
        catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.IM_USED, e.getStatusCode());
            throw e;
        }
    }

}
