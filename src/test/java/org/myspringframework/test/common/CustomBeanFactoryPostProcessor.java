package org.myspringframework.test.common;

import org.myspringframework.beans.BeansException;
import org.myspringframework.beans.PropertyValue;
import org.myspringframework.beans.PropertyValues;
import org.myspringframework.beans.factory.ConfigurableListableBeanFactory;
import org.myspringframework.beans.factory.config.BeanDefinition;
import org.myspringframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("CustomBeanFactoryPostProcessor#postProcessBeanFactory");
		BeanDefinition personBeanDefiniton = beanFactory.getBeanDefinition("person");
		PropertyValues propertyValues = personBeanDefiniton.getPropertyValues();
		//将person的name属性改为ivy
		propertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
	}
}
