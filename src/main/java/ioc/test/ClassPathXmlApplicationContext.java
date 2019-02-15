package ioc.test;

import java.util.Map;

import ioc.AutowiredBeanFactory;
import ioc.BeanDefinition;
import ioc.BeanFactory;
import ioc.ResourceLoader;
import ioc.XmlBeanDefinitionReader;

/**
 * spring的窗口的操作入口， 有点像FileSystemXmlApplicationContext
 * @author guangfeng.yang
 *
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

	private String config;
	
	public ClassPathXmlApplicationContext(String config) {
		super();
		this.config = config;
		refresh();
	}

	@Override
	public Object getBean(String name) {
		Object bean = null;
		try {
			bean = this.getBeanFactory().getBean(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	/* 获取配置文件，读取xml文件，并且加载bean在beanFacotry的容器上
	 * @see ioc.test.AbstractApplicationContext#refresh()
	 */
	@Override
	public void refresh() {
		 // 创建一个XML解析器，携带一个资源加载器
	    XmlBeanDefinitionReader xml = new XmlBeanDefinitionReader(new ResourceLoader());
	    // 解析该文件
	    try {
			xml.readerXML(config);
			// 创建一个自动注入bean工厂
		    AutowiredBeanFactory beanfactory = new AutowiredBeanFactory();
		    this.setBeanFactory(beanfactory);
		    // 循环xml中的所有bean
		    for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xml.getRegistry().entrySet()) {
		      // 将XML容器中的bean注册到bean工厂
		      beanfactory
		          .registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
