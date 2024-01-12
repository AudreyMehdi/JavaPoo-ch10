package co.simplon.poo.ch1;

import org.junit.jupiter.api.Test;

//https://www.baeldung.com/java-unit-testing-best-practices

public class TestVehicule {

	@Test
	void testAttributs() {
		Vehicule voiture = new Vehicule();
		voiture.marque = "Honda";
	}
		

	// Autres méthodes de tests
}
