package cn.imzjw.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 * 耦合 : 程序之间的依赖关系
 * 包括 : 类之间的依赖、方法之间的依赖
 * 解耦 : 降低程序直之间的关系
 * 实际开发中 应该做到 编译期不依赖，运行时才依赖
 * 解耦的思路:
 * 第一步: 使用反射来创建对象，而避免使用 new 关键字
 * 第二步: 通过读取配置来获取要创建对象的全限定类名
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 10:40
 */
public class JdbcDemo1 {

	public static void main(String[] args) throws Exception {
		// 1. 注册驱动
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// com.mysql.jdbc.Driver 写死了, 如果要用到 Oracle 还要改这里 ❌
		Class.forName("com.mysql.jdbc.Driver");

		// 2. 获取链接
		Connection connection = DriverManager.getConnection("jdbc:mysql://120.25.243.164:3306/spring", "garvey", "asd");

		// 3. 获取操作数据库的预处理对象
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM account");

		// 4. 执行sql，得到结果集
		ResultSet rs = ps.executeQuery();

		// 5. 遍历结果集
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}

		// 6. 释放资源 (先开的最后关)
		rs.close();
		ps.close();
		connection.close();
	}
}