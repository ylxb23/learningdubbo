package com.zero.ld.server.init;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * dubbo服务消费方App入口
 * @date 2017年12月18日 下午2:56:13
 * @author zero
 */
@EnableDubboConfiguration
@SpringBootApplication(scanBasePackages= {"com.zero.ld.server"})
public class ConsumerApp {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerApp.class);
	
	public static void main(String[] args) throws IOException {
		SpringApplicationBuilder springBuilder = new SpringApplicationBuilder(ConsumerApp.class);
		ConfigurableApplicationContext context =  springBuilder.web(true).run(args);
		logger.info("context start with {} beans inited...", context.getBeanDefinitionCount());
	}
	
}
