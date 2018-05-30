package com.bdaywish.services;

import java.util.List;

import com.bdaywish.bo.UserBO;
import com.bdaywish.pojo.User;
import com.bdaywish.utils.WishOnBdayException;

public interface BdayWishService {

	List<UserBO> getUsersByTime() throws WishOnBdayException;

	void addUser(UserBO userbo);

	UserBO findUserById(Integer id);

	void sendMail(Integer id, String mailSubject, String message);

	List<UserBO> getUsers();

	void sendSMS(List<Integer> idsList);


}
