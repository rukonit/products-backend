package com.rukon.services.impl;

import com.rukon.models.P;
import com.rukon.models.Product;
import com.rukon.services.ProductService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rukon.repository.ProductRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Collection<P> findAllProducts() {
        return productRepository.findAllProduct();
    }


    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            productRepository.deleteById(id);
            jsonObject.put("message", "Product deleted successfully");
            }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
