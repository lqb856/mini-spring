package org.myspringframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import org.myspringframework.beans.factory.config.BeanDefinition;
import org.myspringframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author derekyi
 * @date 2020/12/26
 */
public class ClassPathScanningCandidateComponentProvider {

	public Set<BeanDefinition> findCandidateComponents(String basePackage) {
		Set<BeanDefinition> candidates = new LinkedHashSet<BeanDefinition>();
		// 扫描有org.myspringframework.stereotype.Component注解的类
		Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
		for (Class<?> clazz : classes) {
			BeanDefinition beanDefinition = new BeanDefinition(clazz);
			candidates.add(beanDefinition);
		}
		return candidates;
	}
}
