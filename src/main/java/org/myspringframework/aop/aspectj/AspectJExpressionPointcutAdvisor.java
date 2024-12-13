package org.myspringframework.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.myspringframework.aop.Pointcut;
import org.myspringframework.aop.PointcutAdvisor;

/**
 * aspectJ 表达式的advisor。
 * 
 * Spring 使用 Advisor 来结合 Advice 和 Pointcut，形成完整的通知-切点组合。
 *
 * @author derekyi
 * @date 2020/12/6
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

	private AspectJExpressionPointcut pointcut;

	private Advice advice;

	private String expression;

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public Pointcut getPointcut() {
		if (pointcut == null) {
			pointcut = new AspectJExpressionPointcut(expression);
		}
		return pointcut;
	}

	@Override
	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
}
