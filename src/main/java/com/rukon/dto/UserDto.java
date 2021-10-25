package com.rukon.dto;

import com.rukon.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String userName;
    private String roles;
    private String active;
    private Set<Cart> cart = new HashSet<Cart>();;

}
