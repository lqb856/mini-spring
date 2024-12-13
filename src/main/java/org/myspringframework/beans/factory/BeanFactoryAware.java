package org.myspringframework.beans.factory;

import org.myspringframework.beans.BeansException;

/**
 * 实现该接口，能感知所属 BeanFactory
 *
 * @author derekyi
 * @date 2020/12/1
 */
public interface BeanFactoryAware extends Aware {

	void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
