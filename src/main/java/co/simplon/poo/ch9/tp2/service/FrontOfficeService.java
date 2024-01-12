package co.simplon.poo.ch9.tp2.service;

import java.util.List;

import co.simplon.poo.ch9.tp2.model.Customer;
import co.simplon.poo.ch9.tp2.model.Order;
import co.simplon.poo.ch9.tp2.model.OrderDetail;
import co.simplon.poo.ch9.tp2.model.Product;
import co.simplon.poo.ch9.tp2.model.Tag;

public interface FrontOfficeService {
	
	List<Product> searchByTag(Tag tag);
	void createOrder(Customer customer);
	void addOrderDetail(Order order,OrderDetail detail);
	void validateOrder(Order order);
}
