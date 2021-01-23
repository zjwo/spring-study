package cn.imzjw.service.impl;

import cn.imzjw.dao.IAccountDao;
import cn.imzjw.entity.Account;
import cn.imzjw.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现类
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/21 17:00
 */
@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

	@Override
	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}

	@Override
	public Account findAccountById(Integer id) {
		return accountDao.findAccountById(id);
	}

	@Override
	public void saveAccount(Account account) {
		accountDao.saveAccount(account);
	}

	@Override
	public void delAccount(Integer id) {
		accountDao.delAccount(id);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}
}
