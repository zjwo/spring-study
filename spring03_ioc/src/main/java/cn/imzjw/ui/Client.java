package cn.imzjw.ui;

import cn.imzjw.dao.IAccountDao;
import cn.imzjw.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟表现层，用于调用业务层
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:41
 */
public class Client {

	/**
	 * 获取 spring 的 ioc 核心容器，并根据 id 获取对象
	 * ApplicationContext 三个常用实现类:
	 * ClassPathXmlApplicationContext: 可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话就加载不了 ( 更常用 )
	 * FileSystemXmlApplicationContext: 可以加载磁盘任意路径下的文件, 但是必须要有访问权限
	 * AnnotationConfigApplicationContext: 用于读取注解创建容器的
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\garvey\\Desktop\\bean.xml");

		IAccountService service = ac.getBean("accountService", IAccountService.class);

		IAccountDao dao = (IAccountDao) ac.getBean("accountDao");

		System.out.println(service);
		System.out.println(dao);
	}
}