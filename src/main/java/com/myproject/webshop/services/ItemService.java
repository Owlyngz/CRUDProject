package com.myproject.webshop.services;

import com.myproject.webshop.dto.ItemDto;
import com.myproject.webshop.mapper.ItemMapper;
import com.myproject.webshop.model.Item;
import com.myproject.webshop.repositories.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Component
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDto> getAllDtoItems() {
        List<Item> foundItems = itemRepository.findAllItems();
        return itemMapper.toDtoList(foundItems);
    }

    public List<ItemDto> saveItem(Item item) {
        itemRepository.save(item);
        return getAllDtoItems();
    }

    public ItemDto findItemById(Long id) {
        ItemDto itemDto = itemMapper.toDto(itemRepository.findItemById(id));
        return itemDto;
    }

    public ItemDto updateItem(ItemDto itemDto, Long id) {

        Item foundItem = itemRepository.findItemById(id);

        itemMapper.updateItem(itemDto, foundItem);

        saveItem(foundItem);

        return findItemById(id);

    }

    public List<ItemDto> deleteItemById(Long id) {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.METHOD_NOT_ALLOWED);
        }
        if (id == 0) {
            throw new HttpClientErrorException(HttpStatus.IM_USED);
        }
        itemRepository.deleteById(id);
        return getAllDtoItems();
    }


}
