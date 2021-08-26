package com.rukon.repository;


import com.rukon.models.P;
import com.rukon.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.rukon.models.P(product_id, name) FROM product")
    Set<P> findAllProduct();


}
