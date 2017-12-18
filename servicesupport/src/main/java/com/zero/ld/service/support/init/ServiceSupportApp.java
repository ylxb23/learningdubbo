package com.zero.ld.service.support.init;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

/**
 * 
 * @date 2017年12月18日 下午10:08:44
 * @author zero
 */
@DubboComponentScan
public class ServiceSupportApp {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"dubbo-provider.xml"});
		context.start();
		System.out.println("beans: " + context.getBeanDefinitionNames());
		System.in.read();
	}

}
