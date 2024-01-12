package co.simplon.poo.ch10.tp1.repository;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.utils.persistence.CrudRepository;

public interface ProductRepository extends CrudRepository<Product>{
	Product getByLogin(String login);
}
