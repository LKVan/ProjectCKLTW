package support;

import java.util.Properties;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



public class SendEmail {
	
	public static void sendEmail(String sendTo,String subject,String content) {
		String to = "phuongnguyen112002@gmail.com";
		

	      // Sender's email ID needs to be mentioned
	      String from = "nguyenngocphuong11072002@gmail.com";
	      String password = "xyaultomellyhnzc";

	      // Assuming you are sending email from localhost
	     // String host = "localhost";

	      // Get system properties
	      Properties properties = new Properties();
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", "587");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true");
	      

	      // Setup mail server
	     // properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties,new Authenticator() {
	    	  @Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		// TODO Auto-generated method stub
	    		return new PasswordAuthentication(from, password);
	    	}
		});

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Now set the actual message
	         message.setText(content);

	         // Send message
	         Transport.send(message);
	         System.out.println(content);
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
	

}
