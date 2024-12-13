package org.myspringframework.test.common.event;

import org.myspringframework.context.ApplicationContext;
import org.myspringframework.context.event.ApplicationContextEvent;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class CustomEvent extends ApplicationContextEvent {

	public CustomEvent(ApplicationContext source) {
		super(source);
	}
}
