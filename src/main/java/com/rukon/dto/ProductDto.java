package com.rukon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long product_id;
    private String name;
    private String description;
    private String category;
    private float price;
    private int stock;


}
