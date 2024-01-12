package co.simplon.poo.ch9.tp2.service;

import java.util.List;

import co.simplon.poo.ch9.tp2.model.Customer;
import co.simplon.poo.ch9.tp2.model.Order;
import co.simplon.poo.ch9.tp2.model.Product;
import co.simplon.poo.ch9.tp2.model.Tag;

public interface BackOfficeService {
	
	void createProduct(Product product);
	void createTag(Tag tag);
	void addTagToProduct(Tag tag, Product product);
	List<Order> getCustomerOrders(Customer customer);
	List<Order> getPendingOrders();
}
