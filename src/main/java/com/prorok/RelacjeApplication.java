package com.prorok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.prorok.dao.ClientDao;
import com.prorok.dao.OrderDao;
import com.prorok.dao.ProductDao;
import com.prorok.dao.UserDao;
import com.prorok.model.Client;
import com.prorok.model.Order;
import com.prorok.model.Product;
import com.prorok.model.User;
import com.prorok.model.UserDetails;

@SpringBootApplication
public class RelacjeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RelacjeApplication.class, args);

		// UserDao userDao = ctx.getBean(UserDao.class);
		//
		// User user = new User("andrzej","andrzej123","andrzej12@interia.pl");
		// userDao.save(user);
		//
		// UserDetails userDetails = new UserDetails("Andrzje","Kowlaski","Krucza 12
		// Wroclaw");
		// user.setUserDetails(userDetails);
		// userDao.update(user);
		//
		//
		// User user2 = userDao.get(1L);
		// System.out.println(user2);
		//
		// userDao.delete(user2);
		//
		// user2 = userDao.get(1L);
		// System.out.println(user2);
		//
//		ClientDao clientDao = ctx.getBean(ClientDao.class);
//		OrderDao orderDao = ctx.getBean(OrderDao.class);
//
//		Client client = new Client("Jan", "Kowalski", "Buforowa 21A Poznan");
//		clientDao.save(client);
//
//		Order order = new Order("koparka", "koparko-ladowarka STAR", client);
//		orderDao.save(order);
//
//		Order foundOrder = orderDao.get(1L);
//		Client client2 = clientDao.get(1L);
//		System.out.println(foundOrder);
//		System.out.println(client2);
		
		ProductDao productDao = ctx.getBean(ProductDao.class);
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		OrderDao orderDao = ctx.getBean(OrderDao.class);
		
		Client client = new Client("Jan", "Kowalski", "Buforowa 21A Poznan");
		clientDao.save(client);
		System.out.println(client);
		
		Order order = new Order("Zestaw komputerowy Asus");
		order.setClient(client);
		orderDao.save(order);
		
		Product product1 = new Product("Monitor",699.99,"ROG24VX");
		Product product2 = new Product("Karta graficzna",1099.99,"GTX1080TI");
		productDao.save(product1);
		productDao.save(product2);
		
		orderDao.addProductsToOrder(order.getId(), product1,product2);
		
		ctx.close();
	}
}
