package cn.imzjw.service.impl;

import cn.imzjw.service.IAccountService;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
public class AccountServiceImpl implements IAccountService {

	public AccountServiceImpl() {
		System.out.println("对象被创建了");
	}

	@Override
	public void saveAccount() {
		System.out.println("service");
	}
}