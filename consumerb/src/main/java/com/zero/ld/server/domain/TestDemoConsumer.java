package com.zero.ld.server.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zero.ld.service.request.Person;
import com.zero.ld.service.service.DemoService;

/**
 * 
 * @date 2017年12月19日 下午9:13:41
 * @author zero
 */
@Component
public class TestDemoConsumer {
	
	private final Logger logger = LoggerFactory.getLogger(TestDemoConsumer.class);
	
	@Reference(version="1.0.0")
	private DemoService demoService;
	
	
	public void testSayHello() {
		Person person = new Person();
		person.setName("zero");
		person.setAge(23);
		person.setGendar("male");
		logger.info("demoService invoke sayHello: {}", demoService.sayHello(person));
	}
	
}
