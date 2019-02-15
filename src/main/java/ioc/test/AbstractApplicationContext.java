package ioc.test;

import ioc.AbstractBeanFactory;

public abstract class AbstractApplicationContext {

	public AbstractBeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	private AbstractBeanFactory beanFactory;
	
	public abstract Object getBean(String name);
	
	public abstract void refresh(); 
}
