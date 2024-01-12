package co.simplon.poo.ch7.tp3;

import lombok.Data;

@Data
public abstract class Personnage {

	private int energie = 100;// valeur par défaut
	private boolean mort;

	public void subirAttaque(int degats) {
		this.energie -= degats;
		if (energie <= 0)
			this.mort = true;
	}

	public void reprendreDesForces(int energie) {
		if (!mort)
			this.energie += energie;
	}
}
