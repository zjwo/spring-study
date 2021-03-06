package cn.imzjw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 该类是一个配置类，作用是和 bean.xml 是一样的
 * spring 中的新注解
 * Configuration：指定当前类是一个配置类
 *
 * ComponentScan：
 *      作用：用于通过注解指定 spring 在创建容器时要扫描的包
 *      属性：
 *      values：它和 basePackages 的作用是一样的，都是用于指定创建容器时要扫描的包
 *          相当于 xml 中 <context:component-scan base-package="cn.imzjw"/>
 *
 * Bean
 *      作用：用于吧当前方法的返回值作为 bean 对象，存入 spring 的 ioc 容器中
 *      属性：
 *          name：用于指定 bean 的 id。当不写时，默认值是当前方法的名称
 *      注：
 *          当我们使用注解配置时，如果方法有参数，spring 框架会去容器中查找有没有可用的 bean 对象
 *          查找的方法和 Autowired 注解的作用是一样的
 *
 * Import
 *      作用：用于导入其他的配置类
 *      属性:
 *          vaLue：用于指定其他配置类的字节码。
 *                  当我们使用 Import 注解之后，有 Import 注解的类就父配置类，而导入的都是子配置类
 *
 * PropertySource
 *      作用：用于指定 properties 文件的位置属性:
 *      value：指定文件的名称和路径。
 *          关键字：classpath，表示类路径下
 *
 * @author https://blog.imzjw.cn
 * @date 2021/1/23 17:04
 */
// @Configuration
@ComponentScan("cn.imzjw")
@Import(JdbcConfig.class)
@PropertySource("classpath:db.properties")
public class SpringConfiguration {

}