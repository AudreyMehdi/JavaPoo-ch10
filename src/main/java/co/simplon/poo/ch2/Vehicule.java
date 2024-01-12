package co.simplon.poo.ch2;

public class Vehicule {
	public String marque;
	public int annee;

	public Vehicule() {
		// valeurs par défaut initialisée dans ce constructeur. Sinon elle contiennent
		// la valeur par défaut du type, voir dans le tableau du lien ci-dessous
		// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
		this.marque = "une marque a changer";
		this.annee = 1980;
	}

	public Vehicule(String marque) {
		// la variable marque à droite fait référence à celle du constructeur, même si
		// elle a le même nom !
		this.marque = marque;
	}

	public Vehicule(String marque, int annee) {
		// appel du constructeur du dessus, pratqiue pour éviter de répeter le code
		// quand plein de paramètres.
		this(marque);
		this.annee = annee;
	}
	
	//Continuez avec les attributs ajoutés au chapitre 1.

}
