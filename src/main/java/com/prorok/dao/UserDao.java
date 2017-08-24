package com.prorok.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prorok.model.User;
import com.prorok.model.UserDetails;

@Repository
@Transactional
public class UserDao {
	private EntityManager manager;

	@Autowired
	public UserDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(User user) {
		UserDetails details = user.getUserDetails();
		if (details != null && details.getId() == null) {
			manager.persist(details);
		}
		manager.persist(user);
	}

	public User get(Long id) {
		User user = manager.find(User.class, id);
		return user;
	}

	public void update(User user) {
		UserDetails details = user.getUserDetails();
		if (details != null) {
			details = manager.merge(details);
			user.setUserDetails(details);
		}
		manager.merge(user);
	}

	public void delete(User user) {
	User userToDelete = manager.merge(user);
	manager.remove(userToDelete.getUserDetails());
	manager.remove(userToDelete);
	}
}
