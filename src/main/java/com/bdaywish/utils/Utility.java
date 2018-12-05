package com.bdaywish.utils;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;


public class Utility {

	public String sendMail(String name,String toMail, String subject, String message) {
		String imagePath = "./src/main/resources/hbdayWithMessage.jpg";
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");

		final String username = "abhijitjadhav67@gmail.com";//
		final String password = "India@11";
		try {
			if(crunchifyEmailValidator(toMail)) {
				Session session = Session.getDefaultInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(username));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));
				msg.setSubject(subject);
				String finalMessage = "Hi "+name +"!!! \n" +message;
				writeMessageOnImage(finalMessage);
				MimeMultipart multipart = new MimeMultipart("related");
				msg.setSentDate(new Date());
				BodyPart messageBodyPart = new MimeBodyPart();
				String htmlText = "Hi "+name +" !!! <img src=\"cid:image\">";
				messageBodyPart.setContent(htmlText, "text/html");
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();
				DataSource fds = new FileDataSource(
						imagePath);
				messageBodyPart.setDataHandler(new DataHandler(fds));
				messageBodyPart.setHeader("Content-ID", "<image>");
				multipart.addBodyPart(messageBodyPart);
				msg.setContent(multipart);
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

	private void writeMessageOnImage(String message) {
		try {
			String sal = StringUtils.substringBefore(message, StringUtils.lowerCase("\n"));
			String msg = StringUtils.substringAfter(message, StringUtils.lowerCase("\n"));
			BufferedImage bufferedImage = ImageIO.read(new File("./src/main/resources/hbday.jpg"));
			Graphics graphics = bufferedImage.getGraphics();
			// graphics.fillRect(20, 30, 200, 50);
			graphics.setColor(Color.BLACK);
			graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
			graphics.drawString(sal, 70, 35);
			graphics.drawString(msg, 80, 55);

			ImageIO.write(bufferedImage, "jpg", new File(
					"./src/main/resources/hbdayWithMessage.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
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
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String dateString = sdf.format(Calendar.getInstance().getTimeInMillis());
		Date date = new Date (dateString);
		return date.getTime()/1000;
	}

	public String saveProfilePicToLocal(Integer empid,String Fromlocation) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File inFile = new File(Fromlocation);
			File outFile = new File(Constants.IMAGE_PATH + empid +".jpg");
			is = new FileInputStream(inFile);
			os = new FileOutputStream(outFile);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
			}
		}
		return  empid +".jpg";			 
	}
}
