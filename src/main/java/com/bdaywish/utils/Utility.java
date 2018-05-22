package com.bdaywish.utils;


import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utility {

	public String sendMail(String mail) {
		 String recipient = "abhijitjadhav67@gmail.com";
	     String sender = "abhijitjadhav67@gmail.com";
	     String host = "127.0.0.1";
	     Properties properties = System.getProperties();
	     properties.setProperty("mail.smtp.host", host);
	     Session session = Session.getDefaultInstance(properties);
	      try
	      {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(sender));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	         message.setSubject("Bday Wish test mail");
	         message.setText("Bday Wish test mail body ");
	         Transport.send(message);
	         System.out.println("Mail successfully sent");
	      }
	      catch (MessagingException mex) 
	      {
	         mex.printStackTrace();
	      }
		return "success";
	   }
	

	public Long getCurrentDate() { 
	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//	System.out.println(sdf.format(Calendar.getInstance().getTimeInMillis()));
		return Calendar.getInstance().getTimeInMillis()/1000;
	}

}
