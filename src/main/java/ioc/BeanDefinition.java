package ioc;

/**Bean 定义
 * @author Administrator
 *
 */
public class BeanDefinition {

	private Object bean;
	private Class beanClass;
	private String className;
	/**
	 *类的属性的集合 
	 */
	private PropertyValues propertyValues = new PropertyValues();
	public Object getBean() {
		return bean;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}
	public Class getBeanClass() {
		return beanClass;
	}
	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
		try {
			this.beanClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public PropertyValues getPropertyValues() {
		return propertyValues;
	}
	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
	
	
}
