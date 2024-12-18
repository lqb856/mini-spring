package org.myspringframework.beans.factory.config;

import org.myspringframework.beans.BeansException;
import org.myspringframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改BeanDefinition的属性值
 *
 * @author derekyi
 * @date 2020/11/28
 */
public interface BeanFactoryPostProcessor {

	/**
	 * 在所有BeanDefintion加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
	 *
	 * @param beanFactory
	 * @throws BeansException
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
