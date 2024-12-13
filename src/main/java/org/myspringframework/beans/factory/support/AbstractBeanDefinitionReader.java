package org.myspringframework.beans.factory.support;

import org.myspringframework.beans.BeansException;
import org.myspringframework.core.io.DefaultResourceLoader;
import org.myspringframework.core.io.Resource;
import org.myspringframework.core.io.ResourceLoader;

/**
 * @author derekyi
 * @date 2020/11/26
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	private final BeanDefinitionRegistry registry;

	private ResourceLoader resourceLoader;

	protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this(registry, new DefaultResourceLoader());
	}

	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
		this.registry = registry;
		this.resourceLoader = resourceLoader;
	}

	@Override
	public BeanDefinitionRegistry getRegistry() {
		return registry;
	}

	@Override
	public void loadBeanDefinitions(String[] locations) throws BeansException {
		for (String location : locations) {
			loadBeanDefinitions(location);
		}
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
}
