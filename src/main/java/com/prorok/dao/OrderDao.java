package com.prorok.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.prorok.model.Order;
import com.prorok.model.Product;

@Transactional
@Repository
public class OrderDao extends GenericDao<Order, Long> {

		public void addProductsToOrder(Long orderId,Product... products) {
			Order order = get(orderId);
			if(order!=null) {
				for(Product p : products) {
					order.getProducts().add(p);
				}
			}
		}
}
