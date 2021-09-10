package com.rukon.dto;

import com.rukon.models.Cart;

import java.util.HashSet;
import java.util.Set;

public interface UserDto2 {
   String getUserName();
   String getRoles();
   String getActive();
   Set<Cart> getCart();
}
