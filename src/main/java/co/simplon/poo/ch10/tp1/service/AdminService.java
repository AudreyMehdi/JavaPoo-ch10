package co.simplon.poo.ch10.tp1.service;

import java.util.List;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;

public interface AdminService {
	
	List<User> findAllUsers(UserRepository userRepositoryJson);

	void resetAndSendNewPassword(String userId, String newPass) throws Exception;
	
	void disableUser(String userId) throws Exception;
	
	void enableUser(String userId) throws Exception;

	
}
