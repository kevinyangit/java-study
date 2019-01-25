package io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FlushTest {
	public static void main(String[] args) {
		OutputStream out = null;
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
		try {
			bufferedOutputStream.flush();
			//buffer有缓存才会使用flush
			//fileOutputstream没有缓存，不用使用flush
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
