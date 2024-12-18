package org.myspringframework.beans.factory.config;

import org.myspringframework.beans.factory.HierarchicalBeanFactory;
import org.myspringframework.core.convert.ConversionService;
import org.myspringframework.util.StringValueResolver;

/**
 * @author derekyi
 * @date 2020/11/28
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

	/**
	 * @param beanPostProcessor
	 */
	void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

	/**
	 * 销毁单例bean
	 */
	void destroySingletons();

	void addEmbeddedValueResolver(StringValueResolver valueResolver);

	String resolveEmbeddedValue(String value);

	void setConversionService(ConversionService conversionService);

	ConversionService getConversionService();

}
