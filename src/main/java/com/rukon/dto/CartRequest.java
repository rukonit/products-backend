package com.rukon.dto;

import com.rukon.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {

    private Long id;

    private Long productId;

    private int quantity;

}
