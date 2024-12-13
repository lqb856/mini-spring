package org.myspringframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import org.myspringframework.beans.BeansException;
import org.myspringframework.core.io.Resource;
import org.myspringframework.core.io.ResourceLoader;

/**
 * 读取bean定义信息即BeanDefinition的接口
 *
 * @author derekyi
 * @date 2020/11/26
 */
public interface BeanDefinitionReader {

	BeanDefinitionRegistry getRegistry();

	ResourceLoader getResourceLoader();

	void loadBeanDefinitions(Resource resource) throws BeansException;

	void loadBeanDefinitions(String location) throws BeansException;

	void loadBeanDefinitions(String[] locations) throws BeansException;
}
