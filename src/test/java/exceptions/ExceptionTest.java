package exceptions;

import java.io.IOException;
import java.nio.BufferOverflowException;

public class ExceptionTest{
	public static void main(String[] args) {
		try {
			testZero4();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testZero() {
		int a = 1/0;
	}
	//抛出运行异常，虽然不要求捕获
	private static void testZero1() {
		int a = 1/0;
		throw new RuntimeException();
	}

	private static void testZero4()  throws BufferOverflowException{
		throw new RuntimeException();
	}
	//受检查的异常抛出一定要捕获，要不会报错
//	private static void testZero3()  {
//		int a = 1/0;
//		throw new IOException();
//	}
	private static void testZero2() throws IOException {
		int a = 1/0;
	}
	//受检查的异常抛出一定要捕获
//	private static void testZero5()  {
//		int a = 1/0;
//		throw new ClassNotFoundException();
//	}
}