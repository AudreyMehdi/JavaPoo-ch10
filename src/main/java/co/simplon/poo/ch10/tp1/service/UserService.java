package co.simplon.poo.ch10.tp1.service;

public interface UserService {

	void changeMyEmail(String userId, String oldEmail, String newEmail) throws Exception;

	void changeMyPassword(String userId, String oldPass, String newPass) throws Exception;
}
