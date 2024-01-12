package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.impl.ProductRepositoryJson;


public class TestProductRepository {

	private ProductRepositoryJson products = new ProductRepositoryJson("data/json/product.json");
	
	@BeforeEach
	void beforeEachTest() throws IOException {
		products.deleteAll();
	}
	
	@Test
	void testCreateAndRetrieve() throws IOException {
		products.create(new Product("raquette", 123));
		products.create(new Product("balle", 15));
		List<Product> testList = products.retrieve();
		assertEquals(2, testList.size());
	}
	
	
	@Test
	void testDelete() throws IOException {
		Product stylo = products.create(new Product("stylo", 5));
		assertEquals(1, products.count());

		try {
			products.delete(stylo.getId());
			assertEquals(0, products.count());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
		
	@Test
    void testFindByLogin() throws IOException {
		products.create(new Product("raquette", 123)); 
		products.create(new Product("balle", 15));

			assertNotNull(products.getByLogin("raquette"));
			assertNotNull(products.getByLogin("balle"));
			assertNull(products.getByLogin("raquequette"));
			assertNull(products.getByLogin("baballe")); 
		}
	
	@Test
	void testFindById() throws IOException {
		String id = products.create(new Product("raquette", 123)).getId();
		assertEquals("raquette", products.getById(id).getLogin());
	}
		
		
	}
	
	
	
	
	
	
	
	
	
