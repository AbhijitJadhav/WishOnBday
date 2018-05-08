package com.bdaywish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bdaywish.pojo.User;
import com.bdaywish.repo.BdayWishRepository;

@Service
public class BdayWishServiceImpl implements BdayWishService{

	@Autowired
	private BdayWishRepository bdayWishRepository;
	
	@Override
	public void addUser(User user) {
		if(user.toString().trim().length() > 0)
			bdayWishRepository.save(user);
		
	}

}
