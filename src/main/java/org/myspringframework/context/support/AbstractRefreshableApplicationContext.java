package org.myspringframework.context.support;

import org.myspringframework.beans.BeansException;
import org.myspringframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

	private DefaultListableBeanFactory beanFactory;

	/**
	 * 创建beanFactory并加载BeanDefinition
	 *
	 * @throws BeansException
	 */
	protected final void refreshBeanFactory() throws BeansException {
		DefaultListableBeanFactory beanFactory = createBeanFactory();
		loadBeanDefinitions(beanFactory);
		this.beanFactory = beanFactory;
	}

	/**
	 * 创建bean工厂
	 *
	 * @return
	 */
	protected DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactory();
	}

	/**
	 * 加载BeanDefinition
	 *
	 * @param beanFactory
	 * @throws BeansException
	 */
	protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

	public DefaultListableBeanFactory getBeanFactory() {
		return beanFactory;
	}
}
