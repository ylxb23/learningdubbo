package com.zero.ld.service.support.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.zero.ld.service.request.Person;
import com.zero.ld.service.service.DemoService;

/**
 * 测试服务实现
 * @date 2017年12月18日 下午10:24:26
 * @author zero
 */
@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(Person person) {
		System.out.println("invoke comming: " + person);
		return "Hello, " + person.getName();
	}

}
