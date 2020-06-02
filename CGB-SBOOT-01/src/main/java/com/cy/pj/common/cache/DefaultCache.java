package com.cy.pj.common.cache;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Component 注解描述的类应该为由spring管理的一个对象
 * @author pc
 */
@Component
//singleton:单例作用域，默认作用域，此作用域的对象在内存中只有一份。
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//prototype:多例作用域，此作用域的对象spring容器不负责存储，只负责创建和初始化。
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//使用频次比较少的对象可以考虑使用此作用域
@Lazy(true) 
//使用此注解描述的类型可以应用延迟加载策略(懒加载),
//外界不使用此对象时，这个对象是不会创建的。
//大对象，稀少用，可考虑使用懒加载。
public class DefaultCache {//DefaultCache.class
	public DefaultCache() {
		System.out.println("DefaultCache() ");
	}
	//对象的生命周期:创建，初始化，服务，销毁
	//设置对象生命周期初始化方法(会在对象构造方法执行之后执行)
	@PostConstruct 
	public void init() {
		System.out.println("==init()==");
	}
	//设置生命周期销毁方法(会在spring容器销毁对象之前执行)
	@PreDestroy
	public void destroy() {
		System.out.println("==destroy()==");
	}
}
/**
思考：Spring 管理对象有什么优势？(为什么我们要将类的对象交给spring管理呢)
1)可维护性，可扩展性(解耦-对象的创建由工厂负责，然后我们耦合与工厂，需要对象时从工厂获取)
2)高效,低耗(通过池管理对象-bean池,延迟加载-lazy,作用域-scope)

池：牺牲空间赢得时间。


*/


