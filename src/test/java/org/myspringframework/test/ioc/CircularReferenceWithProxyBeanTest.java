package org.myspringframework.test.ioc;

import org.junit.Test;
import org.myspringframework.context.support.ClassPathXmlApplicationContext;
import org.myspringframework.test.bean.A;
import org.myspringframework.test.bean.B;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author derekyi
 * @date 2021/1/30
 */
public class CircularReferenceWithProxyBeanTest {

	@Test
	public void testCircularReference() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-with-proxy-bean.xml");
		A a = applicationContext.getBean("a", A.class);
		B b = applicationContext.getBean("b", B.class);

		assertThat(b.getA() == a).isTrue();
	}
}
