package co.simplon.poo.ch10.tp1.service.impl;



import java.util.List;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.AdminService;
import co.simplon.poo.ch10.tp1.utils.communication.FakeMailUtil;

public class AdminServiceImpl extends FakeMailUtil implements AdminService {
	
	private final UserRepository users;

	public AdminServiceImpl(UserRepository admin) {
		this.users = admin;
	}
	
	
	
	
	
	
	

	@Override
	public List<User> findAllUsers(UserRepository userRepository) {
		
		
	    // Vérifie si userRepository est une instance de UserRepositoryJson
	    if (userRepository instanceof UserRepositoryJson) {
	    	
	        // me met userRepository en type UserRepositoryJson
	        UserRepositoryJson userRepositoryJson = (UserRepositoryJson) userRepository;
	        
	        // Utilisez userRepositoryJson pour récupérer la liste d'utilisateurs
	        List<User> userList = userRepositoryJson.retrieve();
	        
	        return userList;
	    } else {
	     
	        return null;
	    }
	}

	
	
	

	@Override
	public void resetAndSendNewPassword(String userId, String newPass) {
		User targetUser = users.getById(userId);

		targetUser.setPassword(newPass);
		try {
			users.update(targetUser, userId);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
			
	
		
	@Override
	public void disableUser(String userId) throws Exception {
		User targetUser2 = users.getById(userId);

		if (targetUser2.isEnable()) {

			targetUser2.setEnable(false);
		} else {
			System.out.println("pas bon");
		}
	}

	@Override
	public void enableUser(String userId) throws Exception {
		User targetUser3 = users.getById(userId);

		if (!targetUser3.isEnable()) {

			targetUser3.setEnable(true);
		} else {
			System.out.println("pas bon");
		}
	}

}
