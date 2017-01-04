package com.hobay.nocash.soa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hobay.nocash.soa.remote.domain.Hello;
import com.hobay.nocash.soa.remote.domain.User;
import com.hobay.nocash.soa.remote.interfaces.HelloServiceRemote;
import com.hobay.nocash.soa.remote.interfaces.UserServiceRemote;

/**
 * Hello world!
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController
{
	@Autowired
	private HelloServiceRemote helloServiceRemote;
	@Autowired
	private UserServiceRemote userServiceRemote;
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST,consumes="application/json", produces="application/json")
	@ResponseBody
	public String hello(@RequestBody Hello hello,@CookieValue("token") String cookie,BindingResult bindingResult) {
		System.out.println("cookie:"+cookie);
		System.out.println("hello:"+hello.getName());
		User user = new User();
		user.setName("user");
		System.out.println(userServiceRemote.hello(user));
		return helloServiceRemote.hello(hello);
	}
	
	
	@RequestMapping(value = "/hello-json", method = RequestMethod.POST)
	@ResponseBody
	public String helloJson(@RequestBody  Hello helloJson) {
		//System.out.println("cookie:"+cookie);
		//Hello helloJson = getParamsObj(Hello.class);
		System.out.println("helloJson:"+helloJson.getName());
		User user = new User();
		user.setName("user");
		System.out.println(userServiceRemote.hello(user));
		return helloServiceRemote.hello(helloJson);
	}
	
	
	

}
