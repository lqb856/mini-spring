package org.myspringframework.test.aop;

import org.junit.Before;
import org.junit.Test;

import org.myspringframework.aop.AdvisedSupport;
import org.myspringframework.aop.ClassFilter;
import org.myspringframework.aop.TargetSource;
import org.myspringframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.myspringframework.aop.framework.CglibAopProxy;
import org.myspringframework.aop.framework.JdkDynamicAopProxy;
import org.myspringframework.aop.framework.ProxyFactory;
import org.myspringframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.myspringframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.myspringframework.test.common.WorldServiceAfterReturnAdvice;
import org.myspringframework.test.common.WorldServiceBeforeAdvice;
import org.myspringframework.test.service.WorldService;
import org.myspringframework.test.service.WorldServiceImpl;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class DynamicProxyTest {

	private AdvisedSupport advisedSupport;

	@Before
	public void setup() {
		WorldService worldService = new WorldServiceImpl();
		advisedSupport = new ProxyFactory();
		//Advisor是Pointcut和Advice的组合
		String expression = "execution(* org.myspringframework.test.service.WorldService.explode(..))";
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(expression);
		AfterReturningAdviceInterceptor methodInterceptor = new AfterReturningAdviceInterceptor(new WorldServiceAfterReturnAdvice());
		advisor.setAdvice(methodInterceptor);
		TargetSource targetSource = new TargetSource(worldService);
		advisedSupport.setTargetSource(targetSource);
		advisedSupport.addAdvisor(advisor);
	}

	@Test
	public void testJdkDynamicProxy() throws Exception {
		WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
		proxy.explode();
	}

	@Test
	public void testCglibDynamicProxy() throws Exception {
		WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
		proxy.explode();
	}

	@Test
	public void testProxyFactory() throws Exception {
		// 使用JDK动态代理
		ProxyFactory factory = (ProxyFactory) advisedSupport;
		factory.setProxyTargetClass(false);
		WorldService proxy = (WorldService) factory.getProxy();
		proxy.explode();

		// 使用CGLIB动态代理
		factory.setProxyTargetClass(true);
		proxy = (WorldService) factory.getProxy();
		proxy.explode();
	}

	@Test
	public void testBeforeAdvice() throws Exception {
		//设置BeforeAdvice
		String expression = "execution(* org.myspringframework.test.service.WorldService.explode(..))";
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(expression);
		MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
		advisor.setAdvice(methodInterceptor);
		advisedSupport.addAdvisor(advisor);
		ProxyFactory factory = (ProxyFactory) advisedSupport;
		WorldService proxy = (WorldService) factory.getProxy();
		proxy.explode();
	}

	@Test
	public void testAdvisor() throws Exception {
		WorldService worldService = new WorldServiceImpl();

		//Advisor是Pointcut和Advice的组合
		String expression = "execution(* org.myspringframework.test.service.WorldService.explode(..))";
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		advisor.setExpression(expression);
		MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
		advisor.setAdvice(methodInterceptor);

		ClassFilter classFilter = advisor.getPointcut().getClassFilter();
		if (classFilter.matches(worldService.getClass())) {
			ProxyFactory proxyFactory = new ProxyFactory();

			TargetSource targetSource = new TargetSource(worldService);
			proxyFactory.setTargetSource(targetSource);
			proxyFactory.addAdvisor(advisor);
//			proxyFactory.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
//			advisedSupport.setProxyTargetClass(true);   //JDK or CGLIB

			WorldService proxy = (WorldService) proxyFactory.getProxy();
			proxy.explode();
		}
	}
}
















