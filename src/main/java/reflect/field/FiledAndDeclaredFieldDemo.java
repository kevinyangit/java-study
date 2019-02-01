package reflect.field;

import java.lang.reflect.Field;

//1. getDeclaredField是可以获取一个类本身的所有字段，包括私有字段. getField只能获取本类及其父类的public 字段. 注意是public的字段，本类的private字段也不能获取到
//2. 如果想要获取父类的所有成员变量（主要是为了拿到私有成员变量，只想获取公有成员变量可以直接使用getField）,可以通过取得当前类的父类的class对象再调用getDeclaredField方法。
//Field类中最常用的是get(Object obj)和set(Object obj, Object value)这两个方法，所以这两个方法是最重要的。
public class FiledAndDeclaredFieldDemo {

	public static void main(String[] args) {
		try {
			Class<?> subClass = Class.forName("reflect.field.Son");
			Field field = subClass.getField("firstName");
			System.out.println(field);
			// 出错， 因为firstName是父类的filed，getDeclaredFiled只能获取当前的类声明的成员变量
			// Field declaredField = forName.getDeclaredField("firstName");
			// System.out.println(declaredField);
			// 检查是不是获取自己类的私有属性,可以获取到
			Field declaredField = subClass.getDeclaredField("dogName");
			System.out.println(declaredField);
			// 检查是不是获取父类的私有属性,不能获取到，报错
			// Field fatherCar = forName.getField("carName");
			// System.out.println(fatherCar);
			//获取父类的私有属性, 只有通过子类来通过父类，再通过父类的来获取
			Class<?> superclass = subClass.getSuperclass();
			Field declaredField2 = superclass.getDeclaredField("carName");
			System.out.println(declaredField2);
			//获取field的数组
			Field[] fields = subClass.getFields();
			System.out.println(fields.length);
			Field[] declaredFields = subClass.getDeclaredFields();
			System.out.println(declaredFields.length);
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
