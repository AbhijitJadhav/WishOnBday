package com.bdaywish.utils;


import java.util.Calendar;

public class Utility {

	public String sendMail() {
		return null;
	}

	public Long getCurrentDate() { 
	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//	System.out.println(sdf.format(Calendar.getInstance().getTimeInMillis()));
		return Calendar.getInstance().getTimeInMillis()/1000;
	}

}
