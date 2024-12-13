package org.myspringframework.context.event;

import org.myspringframework.context.ApplicationContext;
import org.myspringframework.context.ApplicationEvent;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

	public ApplicationContextEvent(ApplicationContext source) {
		super(source);
	}

	public final ApplicationContext getApplicationContext() {
		return (ApplicationContext) getSource();
	}
}
