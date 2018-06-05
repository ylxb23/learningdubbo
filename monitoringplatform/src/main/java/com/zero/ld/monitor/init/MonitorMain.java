package com.zero.ld.monitor.init;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * Dubbo administrator platform
 * 
 * @date 2018年6月4日 下午11:36:09
 * @author zero
 */
@EnableDubboConfiguration
@SpringBootApplication(scanBasePackages= {"com.zero.ld.monitor"})
public class MonitorMain {
	private static final Logger logger = LoggerFactory.getLogger(MonitorMain.class);
	
	private static final CountDownLatch counter = new CountDownLatch(1);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MonitorMain.class, args);
		logger.info("Application {} started with {} beans inited", context.getApplicationName(), context.getBeanDefinitionCount());
		try {
			counter.await();
		} catch (InterruptedException e) {
			logger.error("Application {} shutdown with InterruptedException", context.getApplicationName(), e);
		}
	}

}
