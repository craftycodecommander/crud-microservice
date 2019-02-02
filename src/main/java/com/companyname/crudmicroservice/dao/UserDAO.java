package com.companyname.crudmicroservice.dao;

import java.util.List;

import com.companyname.crudmicroservice.common.User;

public interface UserDAO {
	
	List<User> getUsers();
	
	User getUser(Long id);
	
	User updateUser(User user);

	User addUser(User user);

	void deleteUser(Long id);
	
}
