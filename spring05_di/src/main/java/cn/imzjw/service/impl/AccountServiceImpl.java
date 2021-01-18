package cn.imzjw.service.impl;

import cn.imzjw.service.IAccountService;

import java.util.Date;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
public class AccountServiceImpl implements IAccountService {

	/**
	 * 如果是经常变化的数据，并不适用于注入的方式
	 */
	private String name;
	private Integer age;
	private Date date;

	public AccountServiceImpl(String name, Integer age, Date date) {
		this.name = name;
		this.age = age;
		this.date = date;
	}

	@Override
	public void saveAccount() {
		System.out.println("service、 name=" + name + ", age=" + age + ", date=" + date);
	}
}