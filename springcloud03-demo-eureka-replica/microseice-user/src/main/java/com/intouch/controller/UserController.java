package com.intouch.controller;

import com.intouch.service.UserService;
import com.intouch.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userservice;
//	根据id查询单个用户的请求
	@GetMapping("/{id}")
	public User getOne(@PathVariable Integer id){
		User user = userservice.queryOne(id);
		return user;
	}

//	查询所有用户
	@GetMapping
	public List<User> findAll(){
		List<User> userList=userservice.listAll();
		return userList;
	}
//	添加一名用户
	@PostMapping
	public String addUser(@RequestBody User user){
		userservice.add(user);
		return "成功添加一名用户";
	}

//	修改一名用户
	@PutMapping("/{id}")
	public  String modifyInfo(@RequestBody User user,@PathVariable Integer id){
//		设置id
		user.setId(id);
		userservice.modify(user);
		return "成功修改一名用户！";
	}

//	删除一名用户
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id){
		userservice.deleteOne(id);
		return "成功删除一名用户！";
	}
}
