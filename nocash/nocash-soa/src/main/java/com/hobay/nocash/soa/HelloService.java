package com.hobay.nocash.soa;
import org.springframework.stereotype.Service;

import com.hobay.nocash.soa.remote.domain.Hello;
import com.hobay.nocash.soa.remote.interfaces.HelloServiceRemote;
/**
 * Hello world!
 *
 */
@Service("helloServiceRemote")
public class HelloService implements HelloServiceRemote
{

	public String hello(Hello hello) {
		System.out.println("hello dubbo service");
		return "hello dubbo22222";
	}
    
}
