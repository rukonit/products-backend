package com.rukon.services.impl;

import com.rukon.model.Cart;
import com.rukon.repository.CartRepository;
import com.rukon.services.CartService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService<Cart> {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Collection<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findbyId(Long Id) {
        return cartRepository.findById(Id);
    }

    @Override
    public Cart saveOrUpdate(Cart cart) {
        return cartRepository.saveAndFlush(cart);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            cartRepository.deleteById(id);
            jsonObject.put("message", "Product deleted successfully from the cart");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
    }

