package clazz.loader;

public class TestClassLoader {
	public static void main(String[] args) {
		System.out.println(TestClassLoader.class.getResource(""));
		System.out.println(TestClassLoader.class.getClassLoader().getResource(""));
		System.out.println(TestClassLoader.class.getResource("/"));
		System.out.println(TestClassLoader.class.getClassLoader().getResource("/"));
		System.out.println(TestClassLoader.class.getResource("test.xml"));
		System.out.println(TestClassLoader.class.getResource("/test.xml"));
		System.out.println();
		System.out.println(TestClassLoader.class.getClassLoader().getResource("test.xml"));
		System.out.println(TestClassLoader.class.getClassLoader().getResource("/test.xml"));
	}

}
