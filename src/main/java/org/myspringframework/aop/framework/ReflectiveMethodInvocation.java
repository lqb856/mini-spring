package org.myspringframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zqc
 * @date 2022/12/16
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

	protected final Object proxy;

	protected final Object target;

	protected final Method method;

	protected final Object[] arguments;

	protected final Class<?> targetClass;

	protected final List<Object> interceptorsAndDynamicMethodMatchers;

	private int currentInterceptorIndex = -1;

	public ReflectiveMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
			Class<?> targetClass, List<Object> chain) {
		this.proxy = proxy;
		this.target = target;
		this.method = method;
		this.arguments = arguments;
		this.targetClass = targetClass;
		this.interceptorsAndDynamicMethodMatchers = chain;
	}

	@Override
	public Object proceed() throws Throwable {
		// 初始 currentInterceptorIndex 为 -1，每调用一次 proceed 就把 currentInterceptorIndex 加一
		if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
			// 当调用次数 = 拦截器个数时
			// 触发当前 method 方法
			return method.invoke(this.target, this.arguments);
		}

		Object interceptorOrInterceptionAdvice = this.interceptorsAndDynamicMethodMatchers
				.get(++this.currentInterceptorIndex);
		// 普通拦截器，直接触发拦截器invoke方法
		return ((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);
	}

	@Override
	public Method getMethod() {
		return method;
	}

	@Override
	public Object[] getArguments() {
		return arguments;
	}

	@Override
	public Object getThis() {
		return target;
	}

	@Override
	public AccessibleObject getStaticPart() {
		return method;
	}
}
