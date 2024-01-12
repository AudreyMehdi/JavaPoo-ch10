package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.impl.AdminServiceImpl;


public class TestAdminService {

	private UserRepositoryJson users = new UserRepositoryJson("data/json/users.json");// me sert à créer un fichier de base json vide
																					 
	private AdminServiceImpl adminService = new AdminServiceImpl(users);

	@BeforeEach
	void beforeEachTest() throws IOException {
		users.deleteAll();
	}

	@Test
	void testChangeMyPassword() throws Exception {

		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}

		User user1 = users.getByLogin("user1"); // je récupère un user pour lui changer son mdp

		adminService.resetAndSendNewPassword(user1.getId(), "newPass");
		assertEquals("newPass", users.getByLogin("user1").getPassword());

		AdminServiceImpl.sendFakeEmail("user1", "admin", "newPass");

	}
	
	
	@Test
	void testIsDesable() throws Exception {
		
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		
		User user3 = users.getByLogin("user3"); 
		adminService.disableUser(user3.getId());
		 
		assertEquals(false, user3.isEnable());
		
	}
	
	@Test
	void testEnable() throws Exception {
		
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", false));
		}
		
		User user4 = users.getByLogin("user4"); 
		adminService.enableUser(user4.getId());
		 
		assertEquals(true, user4.isEnable());
		
	}
	
	
	@Test
	void testList() throws Exception {
	    
	    for (int i = 1; i < 2; i++) {
	        users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
	    }

	   // exécute une opération de recherche de tous les utilisateurs via la méthode findAllUsers fournie par l'objet adminService, en utilisant la liste users comme paramètre. La liste résultante de tous les utilisateurs est ensuite stockée dans la variable allUsers
	    List<User> allUsers = adminService.findAllUsers(users);

	  
	    System.out.println(allUsers);
	}

		
}
