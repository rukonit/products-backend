package com.rukon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@JsonIdentityInfo(

        generator = ObjectIdGenerators.PropertyGenerator.class,

        property = "cart_id")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="cart_products",
    joinColumns = {@JoinColumn(name="cart_id",
            referencedColumnName = "cart_id",
            nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="product_id",
            referencedColumnName = "product_id",
            nullable = false, updatable = false)})
    private Set<Product> products = new HashSet<Product>();

    @NotNull
    private int quantitiy;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }


    public Set<Product> getProducts() {
        return products;
    }


    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(int quantitiy) {
        this.quantitiy = quantitiy;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
