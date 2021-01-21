package cn.imzjw.ui;

import cn.imzjw.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层，用于调用业务层
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:41
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

		IAccountService service = ac.getBean("accountServiceImpl", IAccountService.class);
		// IAccountService service2 = ac.getBean("accountServiceImpl", IAccountService.class);

		// System.out.println(ac.getBean("accountDao1", IAccountDao.class));
		service.saveAccount();

		// System.out.println(service == service2);

		((ClassPathXmlApplicationContext) ac).close();
	}
}