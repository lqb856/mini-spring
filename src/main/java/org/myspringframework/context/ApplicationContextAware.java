package org.myspringframework.context;

import org.myspringframework.beans.BeansException;
import org.myspringframework.beans.factory.Aware;

/**
 * 实现该接口，能感知所属ApplicationContext
 *
 * @author derekyi
 * @date 2020/12/1
 */
public interface ApplicationContextAware extends Aware {

	void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
