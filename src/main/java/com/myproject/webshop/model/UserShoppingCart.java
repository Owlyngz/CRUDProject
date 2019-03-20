package com.myproject.webshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user.id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "item.id")
    private Item item;

    public UserShoppingCart(User user, Item item) {
        this.user = user;
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {  //verify if two objects have the same values.
        if (this == o) return true;    //In the first comparison, equals() compares the current object instance with the object that has been passed. If the two objects have the same values, equals() will return true.
        if (o == null || getClass() != o.getClass()) return false;  // In the second comparison, equals()checks to see whether the passed object is null, or if it’s typed as a different class. If it’s a different class then the objects are not equal.
        UserShoppingCart that = (UserShoppingCart) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&   //Finally, equals() compares the objects’ fields.  If two objects have the same field values, then the objects are the same.
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {    //We use the hashcode() method to optimize performance when comparing objects. Executing  hashcode() returns a unique ID for each object in your program
        return Objects.hash(id, user, item);

    }

    // the equals() method to determine whether the values and fields are the same.


}

