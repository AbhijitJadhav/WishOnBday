package com.bdaywish.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bdaywish.bo.UserBO;
import com.bdaywish.pojo.User;
import com.bdaywish.repo.BdayWishRepository;
import com.bdaywish.utils.Utility;
import com.bdaywish.utils.WishOnBdayException;

@Service
public class BdayWishServiceImpl implements BdayWishService{

	@Autowired
	private BdayWishRepository bdayWishRepository;

	private Utility utility = new Utility();

	@Override
	public void addUser(UserBO userbo) {
		User user = new User();
		if(userbo.toString().trim().length() > 0)
			user.setFirstName(userbo.getFirstName());
		user.setLastName(userbo.getLastName());
		user.setEmail(userbo.getEmail());
		user.setPhone(userbo.getPhone());
		user.setDateOfBirth(userbo.getDateOfBirth());
		bdayWishRepository.save(user);
	}

	@Override
	public UserBO findUserById(Integer id) {
		User user = new User();
		UserBO userBO = new UserBO();
		if(id>0) 
			user = bdayWishRepository.findOne(id);
		userBO.setId(user.getId());
		userBO.setFirstName(user.getFirstName());
		userBO.setLastName(user.getLastName());
		userBO.setEmail(user.getEmail());
		userBO.setPhone(user.getPhone());
		userBO.setDateOfBirth(user.getDateOfBirth());
		return userBO;
	}

	@Override
	public List<UserBO> getUsersByTime() throws WishOnBdayException {
		Long time = utility.getCurrentDate();
		List<User> userList = new ArrayList<>();
		List<UserBO> userBOList = new ArrayList<>();
		UserBO userBO = new UserBO();
		userList = bdayWishRepository.findUsersByTime(time);
		if(userList.size()>0) {
			userList.forEach((user)->{
				userBO.setId(user.getId());
				userBO.setFirstName(user.getFirstName());
				userBO.setLastName(user.getLastName());
				userBO.setEmail(user.getEmail());
				userBO.setPhone(user.getPhone());
				userBO.setDateOfBirth(user.getDateOfBirth());
				userBOList.add(userBO);
			});
		} else {
			throw new WishOnBdayException("No one having bday today");
		}
		return userBOList;
	}

	public void sendMail(List<Integer> idsList) {
		idsList.forEach((id)->{
			UserBO userbo = findUserById(id);
			utility.sendMail(userbo.getEmail());
		});
	}

	public List<UserBO> getUsers() {
		List<User> userList = new ArrayList<>();
		List<UserBO> userBOList = new ArrayList<>();
		userList = bdayWishRepository.findAllUsers();
		userList.forEach((user)->{
			UserBO userBO = new UserBO();
			userBO.setId(user.getId());
			userBO.setFirstName(user.getFirstName());
			userBO.setLastName(user.getLastName());
			userBO.setEmail(user.getEmail());
			userBO.setPhone(user.getPhone());
			userBO.setDateOfBirth(user.getDateOfBirth());
			userBOList.add(userBO);
		});
		return userBOList;
	}


}
