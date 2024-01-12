package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;

public class TestUserRepository {

	private UserRepositoryJson users = new UserRepositoryJson("data/json/users2.json");

	@BeforeEach
	void beforeEachTest() throws IOException {
		users.deleteAll();
	}

	@Test
	void testCreateAndRetrieve() throws IOException { // test pour vérifier si bien 2 users 
		users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true));
		users.create(new User("Mina", "p@$$w0rd", "mina@secudev.net", true));
		List<User> testList = users.retrieve();
		assertEquals(2, testList.size());
	}

	@Test
	void testUpdate() throws Exception {
		User stef = users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true));
		assertEquals("stef@secudev.net", users.getByLogin("Stef").getEmail());// test pour vérifier si mail ok
		stef.setEmail("stef@gmail.com"); //modification du mail
		users.update(stef, stef.getId());// save les modifs
		assertEquals("stef@gmail.com", users.getByLogin("Stef").getEmail());// test pour vérifier si changement de mail ok
	}

	@Test
	void testDelete() throws IOException {
		User stef = users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true)); // création d'un user
		assertEquals(1, users.count()); // test pour vérifier si la liste est de 1

		try {
			users.delete(stef.getId());// delete du user
			assertEquals(0, users.count()); // test pour vérifier si la liste est vide
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testFindByLogin() throws IOException { // test pour trouver un user par son login
		users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true)); 
		users.create(new User("Mina", "p@$$w0rd", "mina@secudev.net", true));

		assertNotNull(users.getByLogin("Stef"));
		assertNotNull(users.getByLogin("Mina"));
		assertNull(users.getByLogin("Steph"));// null car "Steph" n'existe pas
		assertNull(users.getByLogin("mina")); // null car "mina" n'existe pas
	}

	@Test
	void testFindById() throws IOException { // test pour vérifier si l'user correspond à l'id
		String id = users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true)).getId();
		assertEquals("Stef", users.getById(id).getLogin());// test pour savoir si l'id correspond bien à "Steph"
	}
}
