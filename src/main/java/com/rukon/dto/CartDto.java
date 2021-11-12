package com.rukon.dto;

import com.rukon.dto.product.ProductDto;
import com.rukon.dto.product.SideDto;
import com.rukon.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long id;

    private ProductDto product;

    private int quantity;

    private Long userId;

    private Set<SideDto> side;
}
