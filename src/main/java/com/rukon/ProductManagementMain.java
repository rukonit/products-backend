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

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ProductManagementMain implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementMain.class, args);
	}

	@Autowired
	private ProductService<Product> productService;

	@Autowired
	private CartService<Cart> cartService;



	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

//		User user = new User("rukon", "123456", "ROLE_ADMIN", "Active");
//
//		userRepository.save(user);

//		Product product = new Product("Ginger", "Grocery Item", "Grocery", (float) 14, 100);
//		productRepository.save(product);


//
//		User user = userRepository.findById((long) 149).get();
//		Cart cart = new Cart();
//
//		Product product = productRepository.findById((long) 5).get();
////
////		Product newProd = new Product(prod.getName(), prod.getDescription(), prod.getCategory(),
////				prod.getPrice(), prod.getStock()
////				);
//
//
//
//		cart.getProducts().add(product);
//		cart.setQuantitiy(10);
//		cart.setUser(user);
////		cart.getUser().add(userRepository.getById((long) 138));
//
////		cart.getProduct().add(productRepository.getById((long) 138));
//		product.getCarts().add(cart);
//		this.cartRepository.save(cart);
//
//		System.out.println(productRepository.findById((long) 138));

//		System.out.println(productRepository.findAllProduct());
		System.out.println(userRepository.findAll().get(0).getUserName());

	}
}
