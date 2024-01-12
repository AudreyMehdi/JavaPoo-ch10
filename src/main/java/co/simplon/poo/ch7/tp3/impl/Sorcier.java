package co.simplon.poo.ch7.tp3.impl;

import co.simplon.poo.ch7.tp3.JetteurDeSort;
import co.simplon.poo.ch7.tp3.Personnage;

public class Sorcier extends Personnage implements JetteurDeSort{

	@Override
	public void redonneEnergie(int energie, Personnage personnage) {
		personnage.reprendreDesForces(energie);		
	}

	@Override
	public void sortEclair(Personnage personnage) {
		personnage.subirAttaque(15);
		
	}

	@Override
	public void sortFeu(Personnage personnage) {
		personnage.subirAttaque(20);		
	}

}
