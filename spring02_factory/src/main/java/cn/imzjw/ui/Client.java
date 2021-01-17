package cn.imzjw.ui;

import cn.imzjw.factory.BeanFactory;
import cn.imzjw.service.IAccountService;

/**
 * 模拟表现层，用于调用业务层
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:41
 */
public class Client {

	public static void main(String[] args) {
		// IAccountService service = new AccountServiceImpl();
		// service.saveAccount();

		for (int i = 0; i < 5; i++) {
			IAccountService service = (IAccountService) BeanFactory.getBean("accountService");
			System.out.println(service);
			service.saveAccount();
		}
	}
}