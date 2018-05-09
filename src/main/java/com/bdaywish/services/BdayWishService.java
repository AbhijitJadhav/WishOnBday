package com.bdaywish.services;

import com.bdaywish.bo.UserBO;
import com.bdaywish.pojo.User;

public interface BdayWishService {

	void addUser(User user);

	UserBO findUserById(Integer id);

}
