package com.bdaywish.utils;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class Utility {

	public String sendMail(String name,String toMail) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		
		final String username = "abhijitjadhav67@gmail.com";//
		final String password = "9527995127";
		try {
			if(crunchifyEmailValidator(toMail)) {
				Session session = Session.getDefaultInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
	
				Message msg = new MimeMessage(session);
	
				msg.setFrom(new InternetAddress("akproakpro2017@gmail.com"));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));
	
				msg.setSubject("Akpro Account Details");
				msg.setText("Hello " + name + "\n\n" + "" + "Your Account Details\n" + "" + "Email Address : " + toMail );
	
				msg.setSentDate(new Date());
				Transport.send(msg);
				System.out.println("Message sent.");
				return "success";
			}
			return "Cant send mail";
		} catch (MessagingException e) {
			System.out.println("Error, cause: " + e);
			return "Cant send mail";
		}
	}
	
	private boolean crunchifyEmailValidator(String email) {
		boolean isValid = false;
		try {
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
			
		} catch (AddressException e) {
			System.out.println("You are in catch block -- Exception Occurred for: " + email);
		}
		
	   }
	

	public Long getCurrentDate() { 
	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//	System.out.println(sdf.format(Calendar.getInstance().getTimeInMillis()));
		return Calendar.getInstance().getTimeInMillis()/1000;
	}

}
