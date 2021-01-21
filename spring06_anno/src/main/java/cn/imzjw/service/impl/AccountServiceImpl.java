package cn.imzjw.service.impl;

import cn.imzjw.dao.IAccountDao;
import cn.imzjw.service.IAccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

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
 * <p>
 * Controller：用于控制层（表现层）
 * Service：用于业务层
 * Repository：用于持久层
 * 以上三个注解的作用和属性与 Component 是一模一样的，他们三个是 spring 框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 * <p>
 * 用于注入数据的
 * 他们的作用就和在 xmL 配置文件中的 bean 标签中写一个<property> 标签的作用是一样的
 * =============================================================================
 * Autowired
 * 作用：自动按照类型注入，只要容器中有唯一的一个 bean 对象类型和要注入的变量类型匹配，就可以注入成功
 * 出现位置：可以是变量上，也可以是方法上
 * 注：使用了注解时，set 方法就不是必须的了
 * <p>
 * Qualifier
 * 作用：在按照类中注入的基础之上再按照名称注入，他在给类成员注入时不能单独使用，但是给方法参数注入时可以
 * 属性：value：用于指定注入 bean 的 id
 * <p>
 * Resource
 * 作用：直接按照 bean 的 id 注入，它可以独立使用
 * 属性：name：用于指定 bean 的 id
 * <p>
 * 以上三个注入都只能注入其它 bean 类型的数据，不能注入基本类型和 String 类型
 * 另外集合类型的注入只能通过 xml 来实现
 * =============================================================================
 * Value
 * 作用：用于注入基本数据类型和 String 类型
 * 属性：value：用于指定数据的值，它可以使用 spring 的 SpEL(也就是 spring 的 EL 表达式)
 * SpEL 写法： ${表达式}
 *
 * <p>
 * 用于改变作用范围的
 * 他们的作用就和在 bean 标签中使用 scope 属性实现的功能是一样的
 * Scope
 * 作用：用于指定 bean 的作用范围
 * 属性：value：指定范围的取值，常用取值：singleton、prototype
 *
 * <p>
 * 和生命周期相关
 * 他们的作用就和在 bean 标签中使用 init-method 和 destroy- method 的作用是一样的
 * PreDestroy：用于指定销毁方法
 * PostConstruct：用于指定初始化方法
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
@Service
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {

	// @Autowired
	// @Qualifier("accountDao2")
	@Resource(name = "accountDao2")
	private IAccountDao accountDao;

	@Override
	public void saveAccount() {
		accountDao.saveAccount();
	}

	@PostConstruct
	public void init() {
		System.out.println("初始化啦..");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("销毁啦..");
	}
}