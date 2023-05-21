package com.demo.services;

import com.demo.model.User;

public interface UserServiced {
		User save(User user);
		User findUserbyName(String name);
		User findUserbyId(Integer id);
}
