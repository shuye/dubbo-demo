package com.hobay.nocash.soa;
import org.springframework.stereotype.Service;

import com.hobay.nocash.soa.remote.domain.User;
import com.hobay.nocash.soa.remote.interfaces.UserServiceRemote;
/**
 * Hello world!
 *
 */
@Service("userServiceRemote")
public class UserService implements UserServiceRemote
{

	public String hello(User hello) {
		System.out.println("user dubbo service");
		return "user dubbo33333";
	}
    
}
