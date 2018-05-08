package com.bdaywish.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bdaywish.pojo.User;
import com.bdaywish.services.BdayWishService;

@RestController
public class BdayWishController {
	
	@Autowired
	private BdayWishService bdayWishService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		String status;
		try {
			bdayWishService.addUser(user);
			status= "user added sucessfully";
		}catch(Exception e) {
			status = e.getMessage();
		}
		return status;
	}

}
