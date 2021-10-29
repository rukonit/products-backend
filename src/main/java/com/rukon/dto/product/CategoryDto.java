package com.rukon.dto.product;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String category;
}
