package reflect.field;

/**
 * 三种不同的实例化的方法的区别
 获取class对象的3种方法
1. 已经得到一个类的实例，可以使用如下方式来得到Class对象.

Class c = 对象名.getClass();

2. 如果在编译期知道类的名字，可以使用如下方法.

Class c = java.awt.Button.class; 
或
Class c = Integer.TYPE;

3. 如果类名在编译期不知道, 但是在运行期可以获得, 可以使用下面的方法

Class c = Class.forName(str);  //注意:str是类的全路径
 * @author guangfeng.yang
 *
 */
public class InstantMethod {
	
	public static void main(String[] args) {
		
//		获取class对象的3种方法
//		1. 已经得到一个类的实例，可以使用如下方式来得到Class对象.
		Son son = new Son();
		Class<? extends Son> class2 = son.getClass();

//		2. 如果在编译期知道类的名字，可以使用如下方法.
		Class<? extends Son> class3 =  reflect.field.Son.class;

		//3. 如果类名在编译期不知道, 但是在运行期可以获得, 可以使用下面的方法

		try {
			Class c = Class.forName("reflect.field.Son");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //注意:str是类的全路径
		
	}

}
