package org.myspringframework.test.ioc;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import org.myspringframework.context.support.ClassPathXmlApplicationContext;
import org.myspringframework.test.bean.Car;

public class LazyInitTest {

	@Test
	public void testLazyInit() throws InterruptedException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:lazy-test.xml");
		System.out.println(System.currentTimeMillis() + ":applicationContext-over");
		TimeUnit.SECONDS.sleep(1);
		Car c = (Car) applicationContext.getBean("car");
		c.showTime();//显示bean的创建时间
	}
}
