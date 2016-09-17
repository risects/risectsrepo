package com.notifications.service;

import org.springframework.stereotype.Service;

/**
 * @author RAHUL
 *
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService{

	public void getName(String name) {
		System.out.println("Name in service layer is " + name);
	}

}
