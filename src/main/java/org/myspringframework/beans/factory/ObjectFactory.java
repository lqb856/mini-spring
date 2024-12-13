package org.myspringframework.beans.factory;

import org.myspringframework.beans.BeansException;

/**
 * @author derekyi
 * @date 2021/1/30
 */
public interface ObjectFactory<T> {

	T getObject() throws BeansException;
}