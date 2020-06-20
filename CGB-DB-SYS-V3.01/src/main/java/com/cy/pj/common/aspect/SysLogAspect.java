package com.cy.pj.common.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * 定义切面对象类型，其特点:
 * 1)使用@Aspect注解修饰
 * 2)切面内部包含切入点和通知的定义
 * 2.1)通过Pointcut注解定义切入点(通常会对应某个类或多个类中的方法的集合)
 * 2.2)通过@Around等注解描述的方法为通知方法(此方法内部要实现扩展业务的织入)
 * @author qilei
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {
	//bean(bean名称)为一个切入点表达式
	@Pointcut("bean(sysUserServiceImpl)")
	public void doLogPointCut() {}
	/**
	 * 环绕通知方法(这个内部可以在目标方法执行之前，之后添加扩展业务逻辑)
	 * @param jp 连接点(封装了切入点中某个正在执行的方法信息)
	 * @return 为目标方法的执行结果
	 */
	@Around("doLogPointCut()")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		log.info("start {}",System.currentTimeMillis());
		try {
		Object result=jp.proceed();//调用逻辑:本类中其它通知-->其它切面-->还有目标方法
		log.info("end {}",System.currentTimeMillis());
		return result;
		}catch(Throwable e) {
		log.error("error {}",e.getMessage());
		throw e;
		}
	}
	

}
