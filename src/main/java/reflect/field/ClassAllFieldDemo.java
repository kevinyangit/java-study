package reflect.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ClassAllFieldDemo {

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
