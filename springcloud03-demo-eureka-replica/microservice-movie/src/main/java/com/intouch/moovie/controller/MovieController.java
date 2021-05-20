package com.intouch.moovie.controller;

import com.intouch.moovie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
	/*采用restful的编程格式发送请求
	* 用于同步客户端HTTP访问。 它简化了与HTTP服务器的通信，并强制执行RESTful原则。
	* 它处理HTTP连接，使应用程序代码提供URL（带有可能的模板变量）并提取结果。
       注意：默认情况下，RestTemplate依靠标准JDK工具建立HTTP连接。
       您可以通过该HttpAccessor.setRequestFactory(org.springframework.http.client.ClientHttpRequestFactory)
       属性切换为使用其他HTTP库，例如Apache HttpComponents，Netty和OkHttp 。
*/
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@GetMapping("/order")
	public String oderTicket(@RequestParam("userId") Integer id){
      //负载junheng
		ServiceInstance serviceInstance=loadBalancerClient.choose("microsevice-user");
//		User user=restTemplate.getForObject("http://microserice-user/user/"+id,User.class);
		User user =restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id, User.class);
		return  user+"购票成功！";

	}
}
