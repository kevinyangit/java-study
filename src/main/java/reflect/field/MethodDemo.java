package reflect.field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * Class.getMethod():获取当前类及所有继承的父类的public修饰的方法。仅包括public
 * 
 * Class.getDeclaredMethod():获取当前类的所有方法，包括public/private/protected/default修饰的方法。
 * 
 * 如果是private的方法，要setAccessabled=true,
 * 告诉安全管理器不做权限的限制，要不无法调用私有的方法。升。Accessable属性是继承自AccessibleObject 类.。功能是启用或禁用安全检查
 * 还能提高速度。
 * 
 * SecurityManager是java安全管理器。
 * 
 * @author guangfeng.yang
 *
 */
public class MethodDemo {

	public static void main(String[] args) {
		try {
			Class<Son> subClass = Son.class;
			Son son = Son.class.newInstance();
			Method declaredMethod = subClass.getDeclaredMethod("say", String.class);
			declaredMethod.invoke(son, "lisi");
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
