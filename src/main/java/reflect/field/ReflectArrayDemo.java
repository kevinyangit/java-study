package reflect.field;

import java.lang.reflect.Array;

/**动态创建数组，并且，可以根据对数据进行遍历，设置值
 * @author guangfeng.yang
 *
 */
public class ReflectArrayDemo {
	
	public static void main(String[] args) {
		//默认创建数组的方法
		int[] a = {1,2,3};
	    //操作数组
	    Object object = Array.get(a, 1);
	    System.out.println(object);
	    Array.set(a, 2, 8);
	    System.out.println(a[2]);
	    int[] dims = new int[] {
	            5,
	            10,
	            15
	        };
	    
		// 注意区分下面两种
	    System.out.println(Integer.TYPE); // int
	    System.out.println(Integer.class); // Integer
	    // 创建一个三维数组，这个数组的三个维度分别是5,10,15

	    Object array = Array.newInstance(Integer.TYPE, dims);
	    System.out.println(array instanceof int [][][]);
	    System.out.println(array instanceof int [][]);
	    //最多支持255维，可以使用二维数组的方式进行一层一层的进行解析和设置值。
	    Class < ?>classType0 = array.getClass().getComponentType(); // 返回数组元素类型
	    System.out.println(classType0); // 三维数组的元素为二维数组，输出：class [[I
	    // 获得第一层的索引为3的数组，返回的是一个二维数组
	    Object arrayObject = Array.get(array, 3);
	    Class < ?>classType = arrayObject.getClass().getComponentType(); // 返回数组元素类型
	    System.out.println(classType); // 二维数组的元素为一维数组，输出：class [I
	    // 此处返回的是一个一维数组
	    arrayObject = Array.get(arrayObject, 5);
	    Class < ?>classType2 = arrayObject.getClass().getComponentType(); // 返回数组元素类型
	    System.out.println(classType2); // 一维数组的元素为int
	    // 给一维数组下标为10的位置设置值为37
	    Array.setInt(arrayObject, 10, 37);

	    int[][][] arrayCast = (int[][][]) array;
	    System.out.println(arrayCast[3][5][10]);

	}

}
