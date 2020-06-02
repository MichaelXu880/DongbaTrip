package com.cy.pj.common.dao;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSourceTests {
	 /**
	  * 运行时spring框架会为此接口类型的属性注入一个对象
	  */
	 @Autowired
	 private DataSource dataSource; //HikariDataSource
	 /**
	  * FAQ:
	  * 1)dataSource这个变量指向的对象的具体类型？HikariDataSource
	  * 2)通过dataSource获取连接的过程是怎样的？(你怎么知道的)
	    2.1)获取连接池(HikariPool)对象，假如还没有池则创建池对象？
	    2.2)基于jdbc api 获取与数据库的连接
	    2.3)将连接对象放入池中(本质放的也是引用)并返回。
	  */
	 @Test
	 void testGetConnection() throws SQLException {
		 //dataSource.getClass() 获取dataSource变量指向的对象的字节码对象
		 //System.out.println(dataSource.getClass().getName());
		 System.out.println(dataSource.getConnection());
	 }
}
