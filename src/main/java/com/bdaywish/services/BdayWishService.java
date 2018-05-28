package com.bdaywish.services;

import java.util.List;

import com.bdaywish.bo.UserBO;
import com.bdaywish.pojo.User;
import com.bdaywish.utils.WishOnBdayException;

public interface BdayWishService {

	List<UserBO> getUsersByTime() throws WishOnBdayException;

	void addUser(UserBO userbo);

	UserBO findUserById(Integer id);

	void sendMail(List<Integer> idsList);

	List<UserBO> getUsers();

	void sendSMS(List<Integer> idsList);


}
