package com.rukon.repository;


import com.rukon.dto.ProductDto;
import com.rukon.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.rukon.dto.ProductDto(product_id, name, description, category, price, stock) FROM product")
    Set<ProductDto> findAllProduct();


}
