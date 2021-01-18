package cn.imzjw.service.impl;

import cn.imzjw.service.IAccountService;

import java.util.Date;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
public class AccountServiceImpl2 implements IAccountService {

	/**
	 * 如果是经常变化的数据，并不适用于注入的方式
	 */
	private String name;
	private Integer age;
	private Date date;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void saveAccount() {
		System.out.println("service、 name=" + name + ", age=" + age + ", date=" + date);
	}
}