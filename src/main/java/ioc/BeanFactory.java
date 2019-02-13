package ioc;

/**需要一个beanFactory 定义ioc 容器的一些行为 比如根据名称获取bean， 比如注册bean，参数为bean的名称，bean的定义
 * @author Administrator
 *
 */
public interface BeanFactory {
	
	/**根据Bean的name来获取Bean对象。
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Object getBean(String name) throws Exception;

	/**注册Bean对象在容器中
	 * @param name
	 * @param bean
	 * @throws Exception
	 */
	void registerBeanDefinition(String name, BeanDefinition bean) throws Exception;

}
