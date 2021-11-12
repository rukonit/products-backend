package com.rukon.services.product.impl;

import com.rukon.dto.product.SideDto;
import com.rukon.exception.ResourceNotFoundException;
import com.rukon.model.product.Side;
import com.rukon.repository.product.SideRepository;
import com.rukon.services.product.SideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SideServiceImpl implements SideService {

    @Autowired
    private SideRepository sideRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SideDto createSide(SideDto productDto) {

        Side side = mapToEntity(productDto);

        Side newSide = sideRepository.save(side);

        return mapToDto(newSide);
    }

    @Override
    public Collection<SideDto> findAll() {
        List<Side> products = sideRepository.findAll();

        List<SideDto> sideDtos = products.stream().map(
                post -> mapToDto(post)
        ).collect(Collectors.toList());

        return sideDtos;
    }

    @Override
    public SideDto findById(Long id) {
        Side side = sideRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("side", "id", id));
        SideDto productDto = mapToDto(side);
        return productDto;
    }


    @Override
    public SideDto saveOrUpdate(SideDto sideDto, long id) {

        Side side = sideRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));

        side.setSide(sideDto.getSide());
        side.setPrice(sideDto.getPrice());


        Side updatedSide = sideRepository.saveAndFlush(side);

        return mapToDto(updatedSide);
    }

    @Override
    public void deleteById(Long id) {
        Side side = sideRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("side", "id", id));

        sideRepository.deleteById(id);

    }

    private SideDto mapToDto(Side side) {
        SideDto sideDto= new SideDto();
        modelMapper.map(side, sideDto);
        return sideDto;
    }

    private Side mapToEntity(SideDto sideDto) {
        Side side = new Side();
        modelMapper.map(sideDto, side);
        return side;
    }
}
