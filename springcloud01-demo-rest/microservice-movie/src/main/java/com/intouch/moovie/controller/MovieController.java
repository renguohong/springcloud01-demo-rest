package com.intouch.moovie.controller;

import com.intouch.moovie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/order")
	public String oderTicket(@RequestParam("userId") Integer id){
//		如何获取指定id的用户?
		User user=restTemplate.getForObject("http://localhost:9001/user/"+id,User.class);
		return  user+"购票成功！";
	}
}
