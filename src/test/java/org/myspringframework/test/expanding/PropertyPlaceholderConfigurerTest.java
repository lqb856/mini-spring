package org.myspringframework.test.expanding;

import org.junit.Test;
import org.myspringframework.context.support.ClassPathXmlApplicationContext;
import org.myspringframework.test.bean.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author derekyi
 * @date 2020/12/13
 */
public class PropertyPlaceholderConfigurerTest {

	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder-configurer.xml");

		Car car = applicationContext.getBean("car", Car.class);
		assertThat(car.getBrand()).isEqualTo("lamborghini");
	}
}
