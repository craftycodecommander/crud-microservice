package com.companyname.crudmicroservice.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.companyname.crudmicroservice.common.User;
import com.companyname.crudmicroservice.dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	Map<Long,User> mapUser2Id = new HashMap<>();
	
	public UserDAOImpl() {
		User user = new User();
		user.setId(78999389L);
		user.setFirstName("Fred");
		user.setSurname("Madagascar");
		user.setUsername("fredmad127");
		user.setEmail("me@fredmadagascar.net");
		mapUser2Id.put(user.getId(), user);
		
		user = new User();
		user.setId(45666642L);
		user.setFirstName("Joe");
		user.setSurname("Soap");
		user.setUsername("soapyjoe724");
		user.setEmail("js@notsurewhereiam.org");
		mapUser2Id.put(user.getId(), user);
	}

	@Override
	public List<User> getUsers() {
		return new ArrayList<User>(mapUser2Id.values());
	}

	@Override
	public User getUser(Long id) {
		return mapUser2Id.get(id);
	}

	@Override
	public User updateUser(User user) {
		mapUser2Id.put(user.getId(), mapUser2Id.get(user.getId()));
		return user;
	}

	@Override
	public User addUser(User user) {
		user.setId(Math.abs(new Random().nextLong()));
		mapUser2Id.put(user.getId(), user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		mapUser2Id.remove(id);
	}

}
