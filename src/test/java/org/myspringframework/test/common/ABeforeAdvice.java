package org.myspringframework.test.common;

import org.myspringframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author derekyi
 * @date 2021/1/30
 */
public class ABeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {

	}
}
