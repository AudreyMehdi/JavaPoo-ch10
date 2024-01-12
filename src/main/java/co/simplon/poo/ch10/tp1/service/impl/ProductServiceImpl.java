package co.simplon.poo.ch10.tp1.service.impl;
// class product
import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.ProductRepository;
import co.simplon.poo.ch10.tp1.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository products;
	
	public ProductServiceImpl(ProductRepository product) {
		this.products= product;
	}

	@Override
	public void changePrix(String productId, Integer oldPrix, Integer newPrix) throws Exception {
		Product targetProduct = products.getById(productId);
		
		if (targetProduct.getPrix().equals(oldPrix)) {
			targetProduct.setPrix(newPrix);
			products.update(targetProduct, productId);
		} else
			throw new Exception("bad old prix");
	}
	}
