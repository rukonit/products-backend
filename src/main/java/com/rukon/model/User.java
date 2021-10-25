package com.rukon.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String password;

    private String roles;

    private String active;



//    @JsonManagedReference
//    public Set<Cart> getCart() {
//        return cart;
//    }
//
//    public void setCart(Set<Cart> cart) {
//        this.cart = cart;
//    }
//
//    public User(String userName, String password, String roles, String active) {
//        this.userName = userName;
//        this.password = password;
//        this.roles = roles;
//        this.active = active;
//    }
}
