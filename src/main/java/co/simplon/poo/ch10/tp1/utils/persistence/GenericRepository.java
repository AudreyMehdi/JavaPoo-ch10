package co.simplon.poo.ch10.tp1.utils.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.simplon.poo.ch10.tp1.model.common.BaseEntity;


public abstract class GenericRepository<T extends BaseEntity> implements CrudRepository<T> {

	protected List<T> data = new ArrayList<T>();
	protected final String dataFilePath;
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public GenericRepository(String dataFilePath) {
		this.dataFilePath = dataFilePath;		
		File file = new File(dataFilePath);
		if (file.exists()) {
			this.data.clear();
			this.load();
		}		
	}

	// CRUDs
	public T create(T entity) throws IOException {
		data.add(entity);
		this.save();
		this.load();
		return entity;
	}

	public List<T> retrieve() {
		return Collections.unmodifiableList(data);
	}

	public T getById(String id) {
		return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
	}

	public void update(T entity, String id) throws Exception {
		delete(id);
		data.add(entity);
		this.save();
	}

	public void delete(String id) throws Exception {
		if (data.stream().noneMatch(p -> p.getId().equals(id)))
			throw new Exception("Pas d'entité avec l'ID " + id);
		data.remove(data.stream().filter(p -> p.getId().equals(id)).findFirst().get());
		this.save();
	}

	public void deleteAll() throws IOException {
		data.clear();
		this.save();
	}

	public int count() {
		return data.size();
	}

	
	protected void load() {

		try {
			this.data = objectMapper.readValue(new File(this.dataFilePath), new TypeReference<List<T>>() {
			});
		} catch (IOException e) {
			//Sous le tapis pour le moment :)
			//e.printStackTrace();
		}
	}

	
	protected void save() throws IOException {
		File file = new File(this.dataFilePath);
		objectMapper.writeValue(file, data);
	}
	
	// Persistence
	/*
	protected abstract void save() throws IOException;

	protected abstract void load();
	*/
}
