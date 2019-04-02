package com.myproject.webshop.dto;

public class ItemDto {

    private Long id;
    private String description;
    private double price;
    private String name;
    private String type;
    private int itemsLeft;
    private String commodityProducer;
    private long quantity;

    public ItemDto(Long id, String description, double price, String name, String type, int itemsLeft, String commodityProducer, long quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
        this.type = type;
        this.itemsLeft = itemsLeft;
        this.commodityProducer = commodityProducer;
        this.quantity = quantity;
    }


    public ItemDto(String description, double price, String name, String type, int itemsLeft, String commodityProducer, long quantity) {
        this.description = description;
        this.price = price;
        this.name = name;
        this.type = type;
        this.itemsLeft = itemsLeft;
        this.commodityProducer = commodityProducer;
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getItemsLeft() {
        return itemsLeft;
    }

    public void setItemsLeft(int itemsLeft) {
        this.itemsLeft = itemsLeft;
    }

    public String getCommodityProducer() {
        return commodityProducer;
    }

    public void setCommodityProducer(String commodityProducer) {
        this.commodityProducer = commodityProducer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

