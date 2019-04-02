package com.myproject.webshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user.id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private List<CartDetails> cartDetailsList;


    public List<CartDetails> getCartDetailsList() { return cartDetailsList; }

    public void setCartDetailsList(List<CartDetails> cartDetailsList) {
        this.cartDetailsList = cartDetailsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
