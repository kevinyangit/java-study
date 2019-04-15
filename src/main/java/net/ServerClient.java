package net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
 
public class ServerClient {
	public static void main(String[] args) throws Exception, IOException {
		System.out.println("---------------------client-------------------");
		Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\2.jpg"));
		
		byte[] b = new byte[1024];
		int len = 0;
		while((len = bis.read(b))!=-1){
			bos.write(b, 0, len);
			//(221,184 
			// 224,839 字节
		}
		bos.flush();
		System.out.println("第二次传输数据");
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("上传完毕");
		dos.flush();
		
		dos.flush();
		
	}
}
