package com.rukon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
    @Column(name="category")
    private String category;

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
