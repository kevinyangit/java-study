package reflect.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
class.newInstance的方法，实际就是调用contructor的instance的方法，他内部缓存构造函数的方法
Constructor类代表某个类中的一个构造方法。很多类都有构造方法，一个类还可能有多个构造方法

 * @author guangfeng.yang
 *
 */
public class ContructorDemo {

	public static void main(String[] args) {
		try {
			 Class<Son> subClass = Son.class;
			Son son = Son.class.newInstance();
			//默认构造方法
			Constructor<Son> declaredMethod = subClass.getConstructor(new Class[]{});
			Son newInstance = declaredMethod.newInstance();
			System.out.println(newInstance);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
