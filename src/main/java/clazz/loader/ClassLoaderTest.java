package clazz.loader;

public class ClassLoaderTest {
	public static void main(String[] args) {
		//获取空字符串，
		System.out.println(ClassLoaderTest.class.getResource(""));
		System.out.println(ClassLoaderTest.class.getClassLoader().getResource(""));
//		file:/D:/Git%20repository/java-study/target/classes/clazz/loader/
//		file:/D:/Git%20repository/java-study/target/classes/
		System.out.println();

		System.out.println(ClassLoaderTest.class.getResource("/"));
		System.out.println(ClassLoaderTest.class.getClassLoader().getResource("/"));
//		file:/D:/Git%20repository/java-study/target/classes/
//		null
		System.out.println();

		System.out.println(ClassLoaderTest.class.getResource("test.xml"));
		System.out.println(ClassLoaderTest.class.getResource("/test.xml"));
//		file:/D:/Git%20repository/java-study/target/classes/clazz/loader/test.xml
//		null
		//不以/开头的文件，与类文件相同的位置，以/开头，那对应的/开头的路径，为什么classLoader找不到呢
		System.out.println();
		System.out.println(ClassLoaderTest.class.getClassLoader().getResource("test.xml"));//这个classLoader，放在哪里都拿不到，除非把文件放在要根目录下，因为他默认是从\目录找。
		System.out.println(ClassLoaderTest.class.getClassLoader().getResource("/test.xml"));//path不能以'/'开头时，path是指类加载器的加载范围，在资源加载的过程中，使用的逐级向上委托的形式加载的，'/'表示Boot ClassLoader中的加载范围，因为这个类加载器是C++实现的，所以加载范围为null。
		//也就是说用classLoader的加载的话，不能出现/
		//null
		//null
		
		//他们的子方法getResource都一样，区别是多一个resolveName来解析文件的路径
		System.getProperty("sun.boot.class.path");
		System.getProperty("java.ext.dirs");
	}

}
