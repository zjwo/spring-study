package cn.imzjw.ui;

import cn.imzjw.dao.IAccountDao;
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
	 * 获取 spring 的 ioc 核心容器，并根据 id 获取对象
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		IAccountService service = ac.getBean("accountService", IAccountService.class);
		IAccountDao dao = (IAccountDao) ac.getBean("accountDao");
		System.out.println(service);
		System.out.println(dao);
	}
}