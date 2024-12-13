package org.myspringframework.test.common.event;

import org.myspringframework.context.ApplicationListener;
import org.myspringframework.context.event.ContextRefreshedEvent;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println(this.getClass().getName());
	}
}
