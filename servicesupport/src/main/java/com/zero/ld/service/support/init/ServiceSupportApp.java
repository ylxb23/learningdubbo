package com.zero.ld.service.support.init;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * Dubbo Service provider
 * 
 * @date 2017年12月18日 下午10:08:44
 * @author zero
 */
@EnableDubboConfiguration
@SpringBootApplication(scanBasePackages= {"com.zero.ld.service"})
public class ServiceSupportApp {
	private static final Logger logger = LoggerFactory.getLogger(ServiceSupportApp.class);
	
	public static void main(String[] args) throws IOException {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ServiceSupportApp.class);
		final ConfigurableApplicationContext context = builder.web(false).run(args);
		logger.info("Application started with {} beans inited", context.getBeanDefinitionCount());
		try {
			Runtime.getRuntime().addShutdownHook(new Thread("shutdown hook thread") {
				@Override
				public void run() {
					shutdownHook(context);
				}
			});
		} catch (Exception e) {
			logger.error("Application shutdown with Exception", e);
		}
	}
	
	static void shutdownHook(ConfigurableApplicationContext context) {
		logger.info("Application shutdown...");
	}

}
