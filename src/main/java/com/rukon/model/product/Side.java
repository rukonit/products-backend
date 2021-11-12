package com.rukon.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Side {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String side;
    private Float price;

//    @ManyToOne()
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;
}
