package com.zero.ld.service.support.init;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * 
 * @date 2017年12月18日 下午10:08:44
 * @author zero
 */
@EnableDubbo(scanBasePackages= {"com.zero.ld.service.support"})
@SpringBootApplication
public class ServiceSupportApp {

	public static void main(String[] args) throws IOException {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ServiceSupportApp.class);
		ConfigurableApplicationContext context = builder.web(false).run(args);
		System.out.println("beans: ");
		Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(System.out::println);
		System.err.println("Enter 'x' to shutdown this application.");
		while(System.in.read() != 120) ;	// char = 'x'
	}

}
