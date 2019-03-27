package com.myproject.webshop.model;

import javax.persistence.*;
import java.util.List;

@Entity

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private double price;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<CartDetails> cartDetails;


    public Item(Long id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Item() {

    }

    public List<CartDetails> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetails> cartDetails) {
        this.cartDetails = cartDetails;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
