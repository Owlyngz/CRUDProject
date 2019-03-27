package com.myproject.webshop.model;

import javax.persistence.*;

@Entity
public class CartDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "item.id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "cart.id")
    private Cart cart;


    public CartDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}

