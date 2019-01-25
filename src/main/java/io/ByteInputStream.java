package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class ByteInputStream {

	public static void main(String[] args) {
		String pathname = null;
		File file = new File(pathname);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int read = fileInputStream.read(buffer);
			System.out.println("read content length: " + read);
			String string = new String(buffer, Charset.forName("utf-8"));
			System.out.println("read content: " + string);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
