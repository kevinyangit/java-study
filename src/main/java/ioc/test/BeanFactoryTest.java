package ioc.test;

import ioc.AutowiredBeanFactory;
import ioc.BeanDefinition;
import ioc.BeanFactory;
import ioc.HelloWorld;
import ioc.PropertyValue;
import ioc.PropertyValues;

public class BeanFactoryTest {
	 // 类全名称
	  private final static String classname = "ioc.HelloWorld";
	  // 属性名称
	  private final static String property = "text";
	  // 属性值
	  private static String value = "测试自动机";
	  // 类id
	  private final static String name = "hello";

	  public static void main(String[] args) throws Exception {
		

	    // 创建自动注册bean工厂
	    BeanFactory beanfactory = new AutowiredBeanFactory();
	    // 创建一个bean定义对象
	    BeanDefinition beandefinition = new BeanDefinition();
	    // 给bean定义对象设置类名并创建class对象
	    beandefinition.setClassName(classname);

	    // 创建一个成员变量集合
	    PropertyValues pv = new PropertyValues();

	    // 给bean定义设置成员变量集合
	    beandefinition.setPropertyValues(pv);

	    // 向bean定义添加成员变量集合
	    beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(property, value));

	    // bean工厂将bean定义注册到容器中
	    beanfactory.registerBeanDefinition(name, beandefinition);

	    // 从容器中获取bean实例
	    HelloWorld hello = (HelloWorld) beanfactory.getBean(name);

	    // 调用实例方法
	    hello.say();


	  }

}
