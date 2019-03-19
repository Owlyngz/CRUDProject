package com.myproject.webshop.controller;

import com.myproject.webshop.dto.ItemDto;
import com.myproject.webshop.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.myproject.webshop.services.ItemService;

import java.util.Collections;
import java.util.List;

@RestController
public class ItemController {


    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<ItemDto> list() { return Collections.emptyList(); }

    @GetMapping("/items")
    public List<ItemDto> allItems() { return itemService.getAllDtoItems(); }

    @GetMapping("/items/{id}")
    public ItemDto findById(@PathVariable Long id) { return itemService.findItemById(id); }

    @PostMapping("/item")
    public List<ItemDto> saveItem(@RequestBody Item item) { return itemService.saveItem(item); }

    @DeleteMapping("/items/{id}")
    public List<ItemDto> deleteItem(@PathVariable Long id) { return itemService.deleteItemById(id); }

    @PutMapping("/items/{id}/put")
    public ItemDto updateItem(@RequestBody ItemDto itemDto, @PathVariable Long id ) {
        return itemService.updateItem(itemDto, id);
    }




}
