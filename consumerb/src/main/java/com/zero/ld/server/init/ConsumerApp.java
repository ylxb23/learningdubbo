package com.zero.ld.server.init;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.zero.ld.service.request.Person;
import com.zero.ld.service.service.DemoService;

/**
 * dubbo服务消费方App入口
 * @date 2017年12月18日 下午2:56:13
 * @author zero
 */
@Configuration
@DubboComponentScan
public class ConsumerApp {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerApp.class);
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"dubbo-consumer.xml"});
		context.start();
		logger.info("beans: {}", context.getBeanDefinitionNames());
		// for test
		testDemoService(context);
		System.in.read();
	}
	
	private static void testDemoService(ApplicationContext context) {
		DemoService demoServiceS = (DemoService) context.getBean("demoService");
		Person person = new Person();
		person.setName("zero");
		person.setAge(23);
		person.setGendar("male");
		logger.info("demoService invoke sayHello: {}", demoServiceS.sayHello(person));
	}

	
}
