package com.rukon.repository;

import com.rukon.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Set<Cart> findAllByUserId(long id);
}
