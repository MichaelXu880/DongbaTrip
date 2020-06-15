package com.cy.pj.common.cache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
/**
 * SpringBoot 脚手架工程单元测试类需要使用@SpringBootTest注解进行描述。
 * 1)第一它是测试类
 * 2)此类会交给spring管理(例如创建对象，为对象属性赋值)
 * @author pc
 */
@SpringBootTest
public class DefaultCacheTests {
	 @Autowired
	 private DefaultCache defaultCache;
	 
	 @Test
	 void testDefaultCache() {
		 System.out.println(defaultCache);
	 }

}




