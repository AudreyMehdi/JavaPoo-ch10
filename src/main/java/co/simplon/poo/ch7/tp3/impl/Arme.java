package co.simplon.poo.ch7.tp3.impl;

import lombok.Data;

@Data
public class Arme {

	private final int DEGATS;

	public Arme(int degat) {
		this.DEGATS = degat;
	}
}
