package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.repository.impl.ProductRepositoryJson;
import co.simplon.poo.ch10.tp1.service.impl.ProductServiceImpl;
import co.simplon.poo.ch10.tp1.model.Product;

public class TestProductService {
	
	private ProductRepositoryJson products = new ProductRepositoryJson("data/json/product.json");
	private ProductServiceImpl productService = new ProductServiceImpl(products);
	
	@BeforeEach
	void beforeEachTest() throws IOException {
		products.deleteAll();
	}

	@Test
	void testChangePrix() throws Exception {
		
		
		products.create(new Product("raquette", 123));
		Product produit1 = products.getByLogin("raquette");

		
		productService.changePrix(produit1.getId(), produit1.getPrix(), 120);
		assertEquals(120, products.getByLogin("raquette").getPrix());
	}
	
}
