package com.rukon.repository.product;

import com.rukon.model.product.Side;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideRepository extends JpaRepository<Side, Long> {

}
