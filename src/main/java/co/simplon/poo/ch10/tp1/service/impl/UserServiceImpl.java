package co.simplon.poo.ch10.tp1.service.impl;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository users;

	public UserServiceImpl(UserRepository users) {
		this.users = users;
	}

	@Override
	public void changeMyPassword(String userId, String oldPass, String newPass) throws Exception {
		User targetUser = users.getById(userId);

		// Pourquoi ce n'est pas safe de faire comme çà, avec le mot de passe en clair
		// ????? Comment devra t-on faire plus tard ?
		if (targetUser.getPassword().equals(oldPass)) {
			targetUser.setPassword(newPass);
			users.update(targetUser, userId);
		} else
			throw new Exception("bad old password");
	}

	@Override
	public void changeMyEmail(String userId, String oldEmail, String newEmail) throws Exception {
		
		User targeUser = users.getById(userId);
		
		if (targeUser.getEmail().equals(oldEmail)) {
			targeUser.setEmail(newEmail);
			users.update(targeUser, userId);
		} else
			throw new Exception("bad old Email");
	}
		
		
	}


