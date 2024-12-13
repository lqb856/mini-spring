package org.springframework.aop;


/**
 * 切点抽象，切点描述在哪些方法上应用通知。
 * 也就是一个方法筛选器。
 *
 * @author derekyi
 * @date 2020/12/5
 */
public interface Pointcut {

	ClassFilter getClassFilter();

	MethodMatcher getMethodMatcher();
}
