package com.intouch.service;

import com.intouch.user.dao.UserDao;
import com.intouch.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void add(User user) {
		userDao.save(user);
	}

	@Override
	public void modify(User user) {
         userDao.save(user);

	}

	@Override
	public void deleteOne(Integer id) {
      userDao.deleteById(id);
	}

	@Override
	public User queryOne(Integer id) {
		User user=userDao.findById(id).get();
		return user;
	}

	@Override
	public List<User> listAll() {
		List<User> userList=userDao.findAll();
		return userList;
	}
}
