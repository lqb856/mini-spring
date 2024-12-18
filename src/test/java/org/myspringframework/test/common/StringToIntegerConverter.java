package org.myspringframework.test.common;

import org.myspringframework.core.convert.converter.Converter;

/**
 * @author derekyi
 * @date 2021/1/16
 */
public class StringToIntegerConverter implements Converter<String, Integer> {
	@Override
	public Integer convert(String source) {
		return Integer.valueOf(source);
	}
}
