package com.rukon.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class P {

    private Long product_id;
    private String name;

    @Override
    public String toString() {
        return "{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                '}';
    }
}


