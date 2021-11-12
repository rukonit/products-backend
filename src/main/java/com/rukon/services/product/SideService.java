package com.rukon.services.product;

import com.rukon.dto.product.SideDto;
import com.rukon.model.product.Side;

import java.util.Collection;

public interface SideService {

        SideDto createSide(SideDto sideDto);

        Collection<SideDto> findAll();

        SideDto findById(Long id);

        SideDto saveOrUpdate(SideDto sideDto, long id);

        void deleteById(Long id);
    
}
