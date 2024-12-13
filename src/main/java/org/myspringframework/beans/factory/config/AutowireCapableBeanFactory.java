package org.myspringframework.beans.factory.config;

import org.myspringframework.beans.BeansException;
import org.myspringframework.beans.factory.BeanFactory;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

	/**
	 * 执行BeanPostProcessors的postProcessBeforeInitialization方法
	 *
	 * @param existingBean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
			throws BeansException;

	/**
	 * 执行BeanPostProcessors的postProcessAfterInitialization方法
	 *
	 * @param existingBean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
			throws BeansException;
}
