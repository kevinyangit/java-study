package ioc.test;

import ioc.ReferenceBean;

public class ClassPathXmlApplicationTest {
	public static void main(String[] args) {
		String config = "myspring.xml";
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(config);
	    // 获取持有另一个bean对象的bean（也是从容器中取得的）
	    ReferenceBean hello = (ReferenceBean) classPathXmlApplicationContext.getBean("referenceBean");

	    // 调用对象方法
	    hello.say();
	}

}
