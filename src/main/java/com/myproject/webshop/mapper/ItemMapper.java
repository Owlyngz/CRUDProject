package com.myproject.webshop.mapper;

import com.myproject.webshop.dto.ItemDto;
import com.myproject.webshop.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class ItemMapper {

    public ItemDto toDto(Item item) {

        return new ItemDto(item.getId(), item.getDescription(), item.getPrice());
    }



    public List<ItemDto>toDtoList(List<Item>items) {

        List<ItemDto> itemDto = new ArrayList<>();

        for (Item item: items)  {
            itemDto.add((toDto(item)));
        }
        return itemDto;
    }


    public Item toEntity(ItemDto itemDto)  {

        return new Item(itemDto.getId(), itemDto.getDescription(), itemDto.getPrice());
    }


    public List<Item> toEntityList(List<ItemDto>itemDtoList) {

        List<Item>entityItemList = new ArrayList<>();

        for (ItemDto itemDto: itemDtoList)  {
            entityItemList.add(toEntity(itemDto));

        }
        return entityItemList;
    }

    public Item updateItem(ItemDto itemDto, Item item) {

        item.setDescription(itemDto.getDescription());
        item.setPrice(itemDto.getPrice());

        return item;
    }

}
