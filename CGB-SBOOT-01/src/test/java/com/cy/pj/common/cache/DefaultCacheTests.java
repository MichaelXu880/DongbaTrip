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
	/**
	 * 此对象为spring框架中的一个场景对象，此对象支持
	 * 1)bean 对象作用域的设置(不同作用域的对象会对应不同的池)
	 * 2)国际化操作
	 * 3).....
	 */
	@Autowired
	private ApplicationContext applicationContext;
     /**
      * @Autowired 描述属性时，spring框架会按照一定的规则为属性赋值。
      * 1)首先进行查找(从spring 容器中查找匹配对象-依赖查找),当找不到时
      *   会出现NoSuchBeanDefinition
      * 2)通过反射为属性赋值(依赖注入)
      */
	 //has a
	 @Autowired
	 private DefaultCache defaultCache01;
	 
	 @Autowired
	 private DefaultCache defaultCache02;
	
	 @Test
	 void testDefaultCache() {
		 System.out.println(defaultCache01==defaultCache02);
	 }
	 
	 @Test
	 void testContainerBean() {
		 DefaultCache defaultCache=
		 applicationContext.getBean("defaultCache",DefaultCache.class);
	     System.out.println(defaultCache);
	 }
}




