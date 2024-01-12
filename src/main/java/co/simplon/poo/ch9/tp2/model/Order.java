package co.simplon.poo.ch9.tp2.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Order {	
	private Customer customer;
	private LocalDateTime validationDate;
	private float amount;
}
