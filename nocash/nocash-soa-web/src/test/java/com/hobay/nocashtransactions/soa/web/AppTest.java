package com.hobay.nocashtransactions.soa.web;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.hobay.nocash.soa.web.WebResultInfoWrapper;


/**
 * Unit test for simple App.
 */
public class AppTest{ 
    public static void main(String[] args) {
		Gson gson = new Gson();
		WebResultInfoWrapper webResultInfoWrapper = new WebResultInfoWrapper();
		webResultInfoWrapper.setState(WebResultInfoWrapper.AUTH_FAILED);
		webResultInfoWrapper.setCode("401");
		webResultInfoWrapper.setMessage("没有权限");
		System.out.println(gson.toJson(webResultInfoWrapper));
		
		User user = new User();
		user.setName("shuye");
		user.setId(1l);
		user.set_id(1l);
		WebResultInfoWrapper webResultInfoWrapperSuccess = new WebResultInfoWrapper();
		webResultInfoWrapperSuccess.setState(WebResultInfoWrapper.SUCCESS);
		webResultInfoWrapperSuccess.setCode("200");
		webResultInfoWrapperSuccess.addResult("user", user);
		System.out.println(gson.toJson(webResultInfoWrapperSuccess));
		
		Page<User> page = new 	Page<User>();
		page.setCurrentPage(1);
		page.setTotalCount(152);
		page.setPageSize(2);
		page.setTotalPages(76);
		User user2 = new User();
		user2.setName("shuye2");
		user2.setId(2l);
		user2.set_id(2l);
		
		List<User> result = new ArrayList<User>();
		result.add(user);
		result.add(user2);
		page.setResult(result);
		
		WebResultInfoWrapper webResultInfoWrapperSuccess2 = new WebResultInfoWrapper();
		webResultInfoWrapperSuccess2.setState(WebResultInfoWrapper.SUCCESS);
		webResultInfoWrapperSuccess2.setCode("200");
		webResultInfoWrapperSuccess2.addResult("user", user);
		webResultInfoWrapperSuccess2.addResult("page", page);
		System.out.println(gson.toJson(webResultInfoWrapperSuccess2));
	}
}
