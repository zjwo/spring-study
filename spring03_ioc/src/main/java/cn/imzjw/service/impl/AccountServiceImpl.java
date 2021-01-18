package cn.imzjw.service.impl;

import cn.imzjw.dao.impl.AccountDaoImpl;
import cn.imzjw.service.IAccountService;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
public class AccountServiceImpl implements IAccountService {

	private AccountDaoImpl accountDao = new AccountDaoImpl();

	public AccountServiceImpl() {
		System.out.println("对象被创建了");
	}

	@Override
	public void saveAccount() {
		accountDao.saveAccount();
	}
}
