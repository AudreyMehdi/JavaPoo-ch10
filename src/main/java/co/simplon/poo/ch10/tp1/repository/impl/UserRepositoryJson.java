package co.simplon.poo.ch10.tp1.repository.impl;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.utils.persistence.GenericRepository;

public class UserRepositoryJson extends GenericRepository<User> implements UserRepository {

	public UserRepositoryJson(String jsonFilePath) {
		super(jsonFilePath);
	}

	public User getByLogin(String login) {

//La boucle sert à rechercher un utilisateur spécifique dans une liste d'utilisateurs (this.data) en se basant sur son nom d'utilisateur (login)
		/*
		 * A l'ancienne
		 *
			User result = null;
			for (User u : this.data) {
				if (u.getLogin().equals(login))
					result = u;
			}
		*/		
		
		//Mieux avec des stream !!
		return this.retrieve().stream().filter(p->p.getLogin().equals(login)).findFirst().orElse(null);
	}
}
