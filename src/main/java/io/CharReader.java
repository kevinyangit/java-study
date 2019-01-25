package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CharReader {
	public static void main(String[] args) {
		String file = null;
		InputStreamReader inputStreamReader = null ;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			 inputStreamReader = new InputStreamReader(fileInputStream,Charset.forName("utf-8"));
			char[] cbuf = new char[100];
			int read = inputStreamReader.read(cbuf);
			System.out.println("content length: " + read);
			for (int i = 0; i < read; i++) {
				char c = cbuf[i];
				System.out.println("index " + i + " is" + cbuf[i]);
			}
			System.out.println(new String(cbuf,0,read));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
