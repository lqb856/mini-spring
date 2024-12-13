package org.myspringframework.aop.framework;

import org.myspringframework.aop.AdvisedSupport;

/**
 * @author zqc
 * @date 2022/12/16
 */
public class ProxyFactory extends AdvisedSupport {


	public ProxyFactory() {
	}

	public Object getProxy() {
		return createAopProxy().getProxy();
	}

	private AopProxy createAopProxy() {
		// 如果手动设置或者 target 类没有实现接口，那就只能使用 CGLIB 进行动态代理
		if (this.isProxyTargetClass() || this.getTargetSource().getTargetClass().length == 0) {
			return new CglibAopProxy(this);
		}
		// TODO(lqb): 如果 TargetMethod 不是接口方法，那么也不能使用 JDK 动态代理
		return new JdkDynamicAopProxy(this);
	}
}
