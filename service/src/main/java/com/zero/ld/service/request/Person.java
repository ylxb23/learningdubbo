package com.zero.ld.service.request;

import java.io.Serializable;

/**
 * 测试对象
 * 
 * @date 2017年12月18日 下午10:21:58
 * @author zero
 */
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7214385860637055451L;

	private String name;
	
	private int age;
	
	private String gendar;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGendar() {
		return gendar;
	}

	public void setGendar(String gendar) {
		this.gendar = gendar;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gendar=" + gendar + "]";
	}

}
