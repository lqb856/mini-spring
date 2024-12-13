package org.myspringframework.context;

import org.myspringframework.beans.factory.HierarchicalBeanFactory;
import org.myspringframework.beans.factory.ListableBeanFactory;
import org.myspringframework.core.io.ResourceLoader;

/**
 * 应用上下文
 *
 * @author derekyi
 * @date 2020/11/28
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
