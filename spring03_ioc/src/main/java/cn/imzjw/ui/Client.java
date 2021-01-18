package cn.imzjw.ui;

import cn.imzjw.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
	 * <p>
	 * 核心容器的两个接口引发的问题
	 * ApplicationContext: 它在构建核心容器时，创建对象采取的策略是立即加载的方式，也就是说，只要一读取配置文件马上就创建配置文件中的配置的对象
	 * BeanFactory: 它在构建核心容器时，创建对象采取的策略是延迟加载的方式，也就是说，什么时候根据 id 获取对象，什么时候才真正的创建对象
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\garvey\\Desktop\\bean.xml");

		// IAccountService service = ac.getBean("accountService", IAccountService.class);

		// IAccountDao dao = (IAccountDao) ac.getBean("accountDao");

		// System.out.println(service);
		// System.out.println(dao);

		// -----------BeanFactory----------------

		Resource res = new ClassPathResource("bean.xml");
		BeanFactory beanFactory = new XmlBeanFactory(res);
		IAccountService ac = beanFactory.getBean("accountService", IAccountService.class);
		System.out.println(ac);
	}
}