package co.simplon.poo.ch9.tp2.model;

import java.util.List;
import lombok.Data;

@Data
public class Product {
	private boolean enable;
	private String label;
	private List<Tag> tags;
	private int stock;
	private float price;
}
