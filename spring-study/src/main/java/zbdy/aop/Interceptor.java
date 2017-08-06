package zbdy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component // @Component needs to be included as a Spring Bean
public class Interceptor {

	//@Before("execution(* zbdy.dao.impl.*.insert*(..))")
	public void before() {
		System.out.println("-------AOP @Before ---------");
	}

	//@AfterReturning("execution(* zbdy.dao.impl.*.insert*(..))")
	public void afterReturing(JoinPoint jp) {
		System.out.println("-------AOP @AfterReturning ---------" + jp.getSignature());
	}

	
	// When combining pointcut sub-expressions, the keywords 'and', 'or' and
	// 'not' can be used in place of '&&', '||' and '!' respectively.
	// @AfterThrowing(value="execution(* zbdy.dao.impl.*.insert*(..)) or execution(* zbdy.service.*.create*(..))", throwing="ex")
	@AfterThrowing(value = "execution(* zbdy.service.*.create*(..))", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("-------AOP @AfterThrowing ---------");
		//System.out.println(ex);
	}

	//@After("execution(* zbdy.dao.impl.*.insert*(..))")
	
	//@After("zbdy.aop.Interceptor.anyServiceOperation()") //Use @Pointcut
	public void after() {
		System.out.println("-------AOP @After ---------");
	}

	//@Around("execution(* zbdy.dao.impl.*.insert*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------AOP @Around starts ---------");
		pjp.proceed();
		System.out.println("-------AOP @Around ends--------------");
	}
	
	@Pointcut("execution(* zbdy.service.*.create*(..))")
	private void anyServiceOperation() {}
}
