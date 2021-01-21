package cn.imzjw.dao.impl;

import cn.imzjw.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:39
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

	@Override
	public void saveAccount() {
		System.out.println("保存成功..222222222");
	}
}
