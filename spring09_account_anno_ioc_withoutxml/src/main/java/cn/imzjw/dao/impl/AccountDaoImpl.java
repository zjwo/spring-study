package cn.imzjw.dao.impl;

import cn.imzjw.dao.IAccountDao;
import cn.imzjw.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/21 17:01
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

	@Autowired
	private QueryRunner queryRunner;

	@Override
	public List<Account> findAllAccount() {
		try {
			return queryRunner.query("SELECT * FROM account", new BeanListHandler<>(Account.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findAccountById(Integer id) {
		try {
			return queryRunner.query("SELECT * FROM account WHERE id = ?", new BeanHandler<>(Account.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveAccount(Account account) {
		try {
			queryRunner.update("INSERT INTO account(name, money) VALUES(?, ?)", account.getName(), account.getMoney());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delAccount(Integer id) {
		try {
			queryRunner.update("DELETE FROM account WHERE id = ?", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(Account account) {
		try {
			queryRunner.update("UPDATE account SET name = ?, money = ? WHERE id = ?", account.getName(), account.getMoney(), account.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}