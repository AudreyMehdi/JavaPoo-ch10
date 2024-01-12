package co.simplon.poo.ch10.tp1.utils.communication;

public class FakeMailUtil {
	public static void sendFakeEmail(String recipient, String subject, String message) {		
			System.out.println("Sending email " + subject + " to " + recipient + "\n"+message);		
	}
}
