package com.bdaywish.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

public class SendSMS {
	// Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "ACe5775ad9d7438044ef8f374dd3e2d004";
	  public static final String AUTH_TOKEN = "22430e2766506178916675877ffac1fd";

	  public void sendSMS(String Phone,String textMessage) {
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
		  MessageCreator messageCreator = Message.creator( 
	        	ACCOUNT_SID, 
	            new PhoneNumber("+4842402767"), new PhoneNumber("+91"+Phone),"Hello" 
	        ); 
		          
	        Message message = messageCreator.create(); 
	        System.out.println(message.getSid()); 
	    } 
	  }

