package cn.imzjw.factory;

import cn.imzjw.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类是存在于 jar 包之中的，我们无法通过修改源码的方式来提供构造函数）
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/18 11:51
 */
public class StaticFactory {

	public static AccountServiceImpl getAccountService() {
		return new AccountServiceImpl();
	}
}
