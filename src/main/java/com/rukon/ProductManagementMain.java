package com.rukon;

import com.rukon.dto.UserDto;
import com.rukon.models.Cart;
import com.rukon.models.Product;
import com.rukon.models.User;
import com.rukon.repository.CartRepository;
import com.rukon.repository.ProductRepository;
import com.rukon.repository.UserRepository;
import com.rukon.services.CartService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rukon.services.ProductService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ProductManagementMain {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementMain.class, args);


	}



	}

