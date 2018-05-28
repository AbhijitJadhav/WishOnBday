package com.bdaywish.utils;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Utility {

	public String sendMail(String name,String toMail, String imageUrl) {
		imageUrl = "https://www.birthdaywishes.expert/wp-content/uploads/2015/06/Happy-birthday-wish-cup-cake-candles-balloons.jpg";
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
				try {
					BufferedImage image = ImageIO.read(new URL(imageUrl));
					Graphics g = image.getGraphics();
					g.setFont(g.getFont().deriveFont(30f));
					g.drawString("Hello World!", 100, 100);
					g.dispose();
					ImageIO.write(image, "jpg", new File(
							"C:/Users/Public/Pictures/image.jpg"));

				} catch (IOException e) {
					e.printStackTrace();
				}
				msg.setFrom(new InternetAddress(username));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));
				msg.setSubject("Happy BirthDay!!!");
				msg.setContent("<H4>Hello " + name + " </H4><BR/>" + "" + "<IMG SRC='C:/Users/Public/Pictures/image.jpg'/>", "text/html" );
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
		return isValid;

	}


	public Long getCurrentDate() { 
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//	System.out.println(sdf.format(Calendar.getInstance().getTimeInMillis()));
		return Calendar.getInstance().getTimeInMillis()/1000;
	}
	
	
}
