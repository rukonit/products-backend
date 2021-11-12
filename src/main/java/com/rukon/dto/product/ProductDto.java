package com.rukon.dto.product;

import com.rukon.model.product.Category;
import com.rukon.model.product.Side;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    private Set<SideDto> side;
}
