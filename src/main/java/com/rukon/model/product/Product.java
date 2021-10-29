package com.rukon.model.product;

import com.rukon.model.Cart;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor

    public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long product_id;

    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @NotNull
    @Column(name = "price")
    private Float price;

    @NotNull
    @Column(name="stock")
    private int stock;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_cart",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"))
    private Set<Cart> carts = new HashSet<Cart>();


}
