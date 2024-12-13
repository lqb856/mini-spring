package org.myspringframework.test.common;

import org.myspringframework.beans.BeansException;
import org.myspringframework.beans.factory.config.BeanPostProcessor;
import org.myspringframework.test.bean.Car;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization, beanName: " + beanName);
		//换兰博基尼
		if ("car".equals(beanName)) {
			((Car) bean).setBrand("lamborghini");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization, beanName: " + beanName);
		return bean;
	}
}
