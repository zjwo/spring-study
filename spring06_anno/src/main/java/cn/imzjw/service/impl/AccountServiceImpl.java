package cn.imzjw.service.impl;

import cn.imzjw.dao.impl.AccountDaoImpl;
import cn.imzjw.service.IAccountService;
import org.springframework.stereotype.Component;

/**
 * 曾经 XML 的 配置:
 * <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 * scope="" init-method="" destroy-method="">
 * <property name="" value="" | ref="" />
 * </bean>
 * 用于创建对象的
 * 他们的作用就和在 XML 配置文件中编写一个<bean> 标签实现的功能是一样的
 * Component：用于吧当前类对象存入 spring 容器
 * 属性：value：用于指定 bean 的 id，当我们不写时，它的默认值是当前类名且首字母小写
 *
 * <p>
 * 用于注入数据的
 * 他们的作用就和在 xmL 配置文件中的 bean 标签中写一个<property> 标签的作用是一样的
 *
 * <p>
 * 用于改变作用范围的
 * 他们的作用就和在 bean 标签中使用 scope 属性 实现 的 功能 是 一样 的
 *
 * <p>
 * 和生命周期相关
 * 他们的作用就和在 bean 标签中使用 init-method 和 destroy- method 的作用是一样的
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
@Component
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
