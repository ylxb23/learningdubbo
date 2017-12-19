package com.zero.ld.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zero.ld.service.request.Person;
import com.zero.ld.service.service.DemoService;

/**
 * 
 * @date 2017年12月19日 下午9:41:59
 * @author zero
 */
@Controller
public class DemoServiceController {
	
	@Reference(version="1.0.0")
	private DemoService demoService;
	
	@ResponseBody
	@RequestMapping(value= {"/sayHello"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String testSayHello(HttpServletRequest request, String name) {
		Person person = new Person();
		person.setName(name);
		person.setAge(23);
		person.setGendar("male");
		String words = demoService.sayHello(person);
		System.out.println(words);
		return words;
	}
}
