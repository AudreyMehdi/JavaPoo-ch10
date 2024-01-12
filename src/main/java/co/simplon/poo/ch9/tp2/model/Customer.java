package co.simplon.poo.ch9.tp2.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Customer {	
	private String email;
	private String passwordHash;
	private LocalDateTime inscriptionDate;
	private List<Order> orders;
}
