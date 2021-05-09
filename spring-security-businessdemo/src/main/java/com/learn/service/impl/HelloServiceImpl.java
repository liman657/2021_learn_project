/**
 * 
 */
package com.learn.service.impl;

import org.springframework.stereotype.Service;

import com.learn.service.HelloService;

/**
 * @author zhailiang
 *
 */
@Service
public class HelloServiceImpl implements HelloService {

	/* (non-Javadoc)
	 * @see com.learn.service.HelloService#greeting(java.lang.String)
	 */
	@Override
	public String greeting(String name) {
		System.out.println("greeting");
		return "hello "+name;
	}

}
