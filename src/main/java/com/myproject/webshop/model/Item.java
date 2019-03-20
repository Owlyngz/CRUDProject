package com.myproject.webshop.model;

import javax.persistence.*;

@Entity

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String price;

//    @ManyToOne
//    @JoinColumn(name = "user.id")
//    private User user;

    public Item(Long id, String description, String price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Item(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public Item() {

    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
