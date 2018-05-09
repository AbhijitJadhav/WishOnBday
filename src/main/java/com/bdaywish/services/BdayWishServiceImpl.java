package com.bdaywish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdaywish.bo.UserBO;
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

	@Override
	public UserBO findUserById(Integer id) {
		User user = new User();
		UserBO userBO = new UserBO();
		if(id>0) 
			user = bdayWishRepository.findOne(id);
		userBO.setFirstName(user.getFirstName());
		userBO.setLastName(user.getLastName());
		userBO.setEmail(user.getEmail());
		userBO.setPhone(user.getPhone());
		userBO.setDateOfBirth(user.getDateOfBirth());
		return userBO;
  }

}
