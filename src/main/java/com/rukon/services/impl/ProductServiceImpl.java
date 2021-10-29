package com.rukon.services.impl;

import com.rukon.dto.product.ProductDto;
import com.rukon.exception.ResourceNotFoundException;
import com.rukon.model.product.Category;
import com.rukon.model.product.Product;
import com.rukon.services.ProductCategoryService;
import com.rukon.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rukon.repository.product.ProductRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = mapToEntity(productDto);


        Product newProduct = productRepository.save(product);

        return mapToDto(newProduct);
    }

    @Override
    public Collection<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();

        List<ProductDto> productDts = products.stream().map(
                post -> mapToDto(post)
        ).collect(Collectors.toList());

        return productDts;
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product", "id", id));
        ProductDto productResponse = mapToDto(product);
        return productResponse;
    }

    @Override
    public ProductDto saveOrUpdate(ProductDto productDto, long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));
        Category category = productCategoryService.findByCategory(productDto.getCategory());

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Product updatedProduct = productRepository.saveAndFlush(product);

        return mapToDto(updatedProduct);
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));

        productRepository.deleteById(id);

    }

    private ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto();
        modelMapper.map(product, productDto);
        productDto.setCategory(product.getCategory().getCategory());
        return productDto;
    }



    private Product mapToEntity(ProductDto productDto) {

        Category category = productCategoryService.findByCategory(productDto.getCategory());
        Product product = new Product();

        modelMapper.map(productDto, product);


        return product;
    }
}
