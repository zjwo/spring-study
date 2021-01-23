package cn.imzjw.test;

import cn.imzjw.config.SpringConfiguration;
import cn.imzjw.entity.Account;
import cn.imzjw.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/21 20:40
 */
public class AccountServiceTest {

	/**
	 * 获取容器
	 *
	 * @return 业务层接口
	 */
	private IAccountService getApplicationContext() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		return ac.getBean("accountServiceImpl", IAccountService.class);
	}

	@Test
	public void testFindAll() {
		// 获取容器 --> 得到业务层对象 --> 执行方法
		getApplicationContext().findAllAccount().forEach(s -> System.out.println(s));
	}

	@Test
	public void testFindOne() {
		System.out.println(getApplicationContext().findAccountById(1));
	}

	@Test
	public void testSave() {
		getApplicationContext().saveAccount(new Account(null, "fff", 1000f));
		testFindAll();
		System.out.println("---添加成功---");
	}

	@Test
	public void testUpdate() {
		// 先获取要修改 account 的 id
		Account account = getApplicationContext().findAccountById(3);
		// 更新信息
		account.setMoney(1234f);
		// 执行修改
		getApplicationContext().updateAccount(account);
		// 修改完成调用查询所有方法 查看是否修改成功
		testFindAll();
		System.out.println("---修改成功---");
	}

	@Test
	public void testDelete() {
		getApplicationContext().delAccount(7);
		testFindAll();
		System.out.println("---删除成功---");
	}
}