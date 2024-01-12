package co.simplon.poo.ch9.tp2.model;

import lombok.Data;

@Data
public class OrderDetail {
	private Order order;
	private Product product;
	private int quantity;
	private float unitPrice;

	public float getSubAmount() {
		return quantity * unitPrice;
	}
}
