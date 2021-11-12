package com.rukon.model;

import ch.qos.logback.classic.db.names.ColumnName;
import com.rukon.dto.CartDto;
import com.rukon.dto.product.SideDto;
import com.rukon.model.product.Product;
import com.rukon.model.product.Side;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.event.spi.LoadEventListener;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;


import javax.naming.Name;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
    public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @NotNull
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ElementCollection
    private Set<SideDto> side;

}
