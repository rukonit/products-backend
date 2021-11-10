package com.rukon.dto;

import com.rukon.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long id;

    private Product product;

    private int quantity;

    private Long userId;
}
