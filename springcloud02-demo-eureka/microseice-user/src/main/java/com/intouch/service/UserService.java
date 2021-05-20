package com.intouch.service;

import com.intouch.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
	//添加一个用户
	public void add(User user);

//	修改用户
	public void modify(User user);
//	删除用户
	public void deleteOne(Integer id);
//	查询单个用户
	public User queryOne(Integer id);
//	列出所有用户
	public List<User> listAll();
}
