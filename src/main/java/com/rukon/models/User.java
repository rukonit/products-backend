package com.rukon.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Cart> cart = new HashSet<Cart>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @JsonManagedReference
    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }

    public User(String userName, String password, String roles, String active) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }
}
