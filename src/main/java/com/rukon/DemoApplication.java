package com.rukon;

import com.rukon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rukon.services.ProductService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ProductService<Product> productService;

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();
		Product product2 = new Product();
		product.setName("Soap");
		product.setDescription("Demo description for soap");

		product2.setName("Tomato");
		product2.setDescription("Tomatoes");
		productService.saveOrUpdate(product);
		productService.saveOrUpdate(product2);
	}
}
