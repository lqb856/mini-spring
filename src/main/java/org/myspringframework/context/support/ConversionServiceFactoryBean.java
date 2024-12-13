package org.myspringframework.context.support;

import org.myspringframework.beans.factory.FactoryBean;
import org.myspringframework.beans.factory.InitializingBean;
import org.myspringframework.core.convert.ConversionService;
import org.myspringframework.core.convert.converter.Converter;
import org.myspringframework.core.convert.converter.ConverterFactory;
import org.myspringframework.core.convert.converter.ConverterRegistry;
import org.myspringframework.core.convert.converter.GenericConverter;
import org.myspringframework.core.convert.support.DefaultConversionService;
import org.myspringframework.core.convert.support.GenericConversionService;

import java.util.Set;

/**
 * @author derekyi
 * @date 2021/1/17
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

	private Set<?> converters;

	private GenericConversionService conversionService;

	@Override
	public void afterPropertiesSet() throws Exception {
		conversionService = new DefaultConversionService();
		registerConverters(converters, conversionService);
	}

	private void registerConverters(Set<?> converters, ConverterRegistry registry) {
		if (converters != null) {
			for (Object converter : converters) {
				if (converter instanceof GenericConverter) {
					registry.addConverter((GenericConverter) converter);
				} else if (converter instanceof Converter<?, ?>) {
					registry.addConverter((Converter<?, ?>) converter);
				} else if (converter instanceof ConverterFactory<?, ?>) {
					registry.addConverterFactory((ConverterFactory<?, ?>) converter);
				} else {
					throw new IllegalArgumentException("Each converter object must implement one of the " +
							"Converter, ConverterFactory, or GenericConverter interfaces");
				}
			}
		}
	}

	@Override
	public ConversionService getObject() throws Exception {
		return conversionService;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public void setConverters(Set<?> converters) {
		this.converters = converters;
	}
}
