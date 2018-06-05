package com.zero.ld.service.support.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.zero.ld.service.request.Person;
import com.zero.ld.service.service.DemoService;

/**
 * 测试服务实现
 * @date 2017年12月18日 下午10:24:26
 * @author zero
 */
@Component	// 注册给Spring IOC
@Service(version="1.0.0")	// 注册到 Dubbo service
public class DemoServiceImpl implements DemoService {
	private final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

	@Override
	public String sayHello(Person person) {
		logger.info("invoke comming: {}", person);
		return "Hello, " + person.getName();
	}

}
