package cn.imzjw.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 和spring连接数据库相关的配置类
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/23 20:27
 */
public class JdbcConfig {

	@Value("${jdbc.driver}")
	private String driver;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	/**
	 * 用于创建一个QueryRunner对象
	 *
	 * @param dataSource
	 * @return
	 */
	@Bean
	@Scope("prototype")
	public QueryRunner createQueryRunner(DataSource dataSource) {
		return new QueryRunner(dataSource);
	}

	/**
	 * 创建数据源对象
	 *
	 * @return
	 */
	@Bean(name = "dataSource")
	public DataSource createDataSource() {
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Bean(name = "ds1")
	public DataSource createDataSource1() {
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}