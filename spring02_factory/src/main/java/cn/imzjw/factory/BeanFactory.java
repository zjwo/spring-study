package cn.imzjw.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建bean对象的工厂
 * <p>
 * Bean：在计算机语言中；表示有可重用组件的含义
 * JavaBean：用java语言编写的可重用组件
 * javabean > 实体类
 * 它就是创建我们service 和 dao 对象的
 * <p>
 * 第一个: 需要一个配置文件来配置我们的 service 和 dao 、 配置的内容: 唯一标识 = 全限定类名（key = value）
 * 第二个：通过读取配置文件中的配置内容, 反射创建对象
 * <p>
 * 配置文件可以是 xml 或 properties
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 12:00
 */
public class BeanFactory {

	/**
	 * 定义 properties 对象 读取配置文件
	 */
	private static Properties props;

	/**
	 * 定义map, 用于存放我们创建之后的对象, 我们称它为容器
	 */
	private static Map<String, Object> beans;

	/**
	 * 使用静态代码块为 properties 对象 赋值
	 */
	static {
		try {
			props = new Properties();
			InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
			props.load(in);
			// 实例化容器
			beans = new HashMap<>();
			// 取出配置文件中所有的kye
			Enumeration<Object> keys = props.keys();
			// 遍历枚举，所有的key
			while (keys.hasMoreElements()) {
				// 取出所有的key
				String key = keys.nextElement().toString();
				// 根据 key 获取 value (全限定类名)
				String beanPath = props.getProperty(key);
				// 反射创建对象
				Object value = Class.forName(beanPath).newInstance();
				// 存入容器
				beans.put(key, value);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化 properties 失败");
		}
	}


	/**
	 * 根据配置文件中的全限定类名使用反射创建对象
	 *
	 * @param beanName bean 名称
	 * @return
	 */
	public static Object getBean(String beanName) {
		return beans.get(beanName);
	}

	/**
	 * 根据配置文件中的全限定类名使用反射创建对象
	 *
	 * @param beanName bean
	 * @return
	 */
	/*public static Object getBean(String beanName) {
		Object bean = null;
		try {
			// 通过 beanName 获取配置文件中的全限定类名
			String beanPath = props.getProperty(beanName);
			// 上一步通过 beanName 获取的全限定类名, 最终利用反射来创建对象
			bean = Class.forName(beanPath).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}*/
}