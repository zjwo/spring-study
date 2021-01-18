package cn.imzjw.ui;

import cn.imzjw.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层，用于调用业务层
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:41
 */
public class Client {

	public static void main(String[] args) {
		// ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

		IAccountService service = ac.getBean("accountService", IAccountService.class);

		service.saveAccount();

		// 手动关闭容器
		ac.close();
	}
}