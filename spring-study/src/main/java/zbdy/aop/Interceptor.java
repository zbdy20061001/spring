package zbdy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component //@Component needs to be included as a Spring Bean
public class Interceptor {
	
	@Before("execution(* zbdy.dao.impl.*.add*(..))")
	public void before(){
		System.out.println("-------AOP before ---------");
	}
	
	@After("execution(* zbdy.dao.impl.*.add*(..))")
	public void after(){
		System.out.println("-------AOP after ---------");
	}
	
	@AfterReturning("execution(* zbdy.dao.impl.*.add*(..))")
	public void afterReturing(JoinPoint jp){
		System.out.println("-------AOP after ---------" + jp.getSignature());
	}
	
	@Around("execution(* zbdy.dao.impl.*.add*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("-------PJP starts ---------");
		pjp.proceed();
		System.out.println("-------PJP ends--------------");
	}
}
