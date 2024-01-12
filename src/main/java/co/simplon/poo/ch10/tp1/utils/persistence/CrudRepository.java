package co.simplon.poo.ch10.tp1.utils.persistence;

import java.io.IOException;
import java.util.List;

import co.simplon.poo.ch10.tp1.model.common.BaseEntity;

public interface CrudRepository<T extends BaseEntity> {	
	T create(T entity) throws IOException;	
	List<T> retrieve();
	T getById(String id);
	void update(T entity, String id) throws Exception;
	void delete(String id) throws Exception;
	void deleteAll() throws IOException;
	int count();
}