package org.myspringframework.test.ioc;

import org.junit.Test;
import org.myspringframework.beans.factory.config.BeanDefinition;
import org.myspringframework.beans.factory.support.DefaultListableBeanFactory;
import org.myspringframework.test.service.HelloService;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

	@Test
	public void testBeanFactory() throws Exception {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
		beanFactory.registerBeanDefinition("helloService", beanDefinition);

		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		helloService.sayHello();
	}
}
