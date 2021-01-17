package cn.imzjw.service.impl;

import cn.imzjw.dao.IAccountDao;
import cn.imzjw.factory.BeanFactory;
import cn.imzjw.service.IAccountService;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
public class AccountServiceImpl implements IAccountService {

	// private AccountDaoImpl accountDao = new AccountDaoImpl();
	private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

	// private int i = 1;

	@Override
	public void saveAccount() {
		int i = 1;
		System.out.println(i);
		accountDao.saveAccount();
		i++;
	}
}
