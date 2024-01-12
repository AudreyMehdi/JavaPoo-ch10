package co.simplon.poo.ch10.tp1.utils.security;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordTools {

	public static String generateRandomPassword() {
		
		//Mot de passe aléatoire avec :
		//2 Majuscules
		String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
		//2 Minuscules
		String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
		//2 chiffres
		String numbers = RandomStringUtils.randomNumeric(2);
		//2 caractères spéciaux
		String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
		//2 caractères alphanumériques
		String totalChars = RandomStringUtils.randomAlphanumeric(2);
		
		//Le tout concaténé
		String combinedChars = upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChar)
				.concat(totalChars);
		
		//Puis mélangé au hasard en mettant chaque caractère dans une liste
		List<Character> pwdChars = combinedChars.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.shuffle(pwdChars);
		
		//Puis passé dans un string builder pour généré le String final
		String password = pwdChars.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
		return password;
	}

}
