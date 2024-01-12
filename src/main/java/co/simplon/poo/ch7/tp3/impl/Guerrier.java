package co.simplon.poo.ch7.tp3.impl;


import co.simplon.poo.ch7.tp3.Bagarreur;
import co.simplon.poo.ch7.tp3.Personnage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@AllArgsConstructor
public class Guerrier extends Personnage implements Bagarreur {
	
	private Arme arme;
	
	@Override
	public void attaquer(Personnage victime) {
		victime.subirAttaque(arme.getDEGATS());
		
	}
}
