package cn.imzjw.service;

import cn.imzjw.entity.Account;

import java.util.List;

/**
 * 账户业务层接口
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/21 16:56
 */
public interface IAccountService {

	/**
	 * 查询所有
	 *
	 * @return
	 */
	List<Account> findAllAccount();

	/**
	 * 查询一个
	 *
	 * @return
	 */
	Account findAccountById(Integer id);

	/**
	 * 保存账户
	 */
	void saveAccount(Account account);

	/**
	 * 删除账户
	 */
	void delAccount(Integer id);

	/**
	 * 更新账户
	 */
	void updateAccount(Account account);
}
