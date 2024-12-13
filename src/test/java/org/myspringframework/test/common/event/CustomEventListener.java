package org.myspringframework.test.common.event;

import org.myspringframework.context.ApplicationListener;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(this.getClass().getName());
	}
}
