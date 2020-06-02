package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 由 @SpringBootApplication 注解描述的类为springboot项目的启动类(入口)。
 * 1)这样的启动类一个项目只能有一个.
 * 2)此类运行时会启动项目的自动配置并扫描此类所在包以及子包中的资源然后进行加载(将类读到内存)。
 * FAQ?
 * 1)如何把一个类交给spring去管理？
 * a)将类放在启动类所在包以及子包中。
 * b)将此类使用spring指定注解进行描述.(例如@Component,@Service,...)
 * 2)如何跟踪这个类是否被加载了？ (通过JVM参数设置进行跟踪:-XX:+TraceClassLoading)
 * 案例：
 * 第一步：在com.cy.pj.common.cache包中定义DefaultCache类
 * 第二步：使用@Component注解对DefaultCache类进行描述
 * 第三步：使用JVM参数-XX:+TraceClassLoading检测DefaultCache类是否被加载了
 */
@SpringBootApplication
public class CgbSboot01Application {//CgbSboot01Application.class (磁盘)
	public static void main(String[] args) {
		SpringApplication.run(CgbSboot01Application.class, args);
	}
}
