package reflect.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*修饰符，如public， private, protected等等
 * 修饰符集被表示为整数, toString的方法，与设置为常量值求与
 * @author guangfeng.yang
 *
 */
public class ModifiersDemo {

	public static void main(String[] args) {
		try {
			Class<?> forName = Class.forName("reflect.field.Son");
			Field[] fields = forName.getFields();
			for (Field field : fields) {
				int modifiers = field.getModifiers();
				System.out.println("field " + field.getName() + " : modifiers " + modifiers);
				String string = Modifier.toString(modifiers);
				// 属性类型
				Class<?> type = field.getType();
				System.out.println(string + " " + type.getName() + " " + field.getName() + ";");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
