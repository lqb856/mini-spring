package org.myspringframework.beans.factory;

import org.myspringframework.beans.BeansException;
import org.myspringframework.beans.factory.config.AutowireCapableBeanFactory;
import org.myspringframework.beans.factory.config.BeanDefinition;
import org.myspringframework.beans.factory.config.BeanPostProcessor;
import org.myspringframework.beans.factory.config.ConfigurableBeanFactory;
import org.myspringframework.beans.factory.support.AbstractBeanFactory;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

	/**
	 * 根据名称查找BeanDefinition
	 *
	 * @param beanName
	 * @return
	 * @throws BeansException 如果找不到BeanDefintion
	 */
	BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	/**
	 * 提前实例化所有单例实例
	 *
	 * @throws BeansException
	 */
	void preInstantiateSingletons() throws BeansException;
}
