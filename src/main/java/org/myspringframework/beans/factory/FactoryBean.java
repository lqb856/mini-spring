package org.myspringframework.beans.factory;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public interface FactoryBean<T> {

	T getObject() throws Exception;

	boolean isSingleton();
}
