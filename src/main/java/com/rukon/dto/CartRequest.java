package com.rukon.dto;

import com.rukon.dto.product.SideDto;
import com.rukon.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.SecondaryTable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {

    private Long id;

    private Long productId;

    private int quantity;

    private Set<SideDto> side;

}
