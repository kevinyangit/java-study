package net;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server {
	public static void main(String[] args) throws Exception {
		System.out.println("----------------------Server------------------");
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\1.jpg"));
		
		byte[] b = new byte[1024];
		int len = 0;
		while((len=bis.read(b)) !=-1){
			bos.write(b, 0, len);
			//循环读取数据会造成流的堵塞 当数据读取完毕后手动结束循环
			if(len!=b.length){
				break ;
			}
		}
		bos.flush();
		System.out.println("接收第二条信息");
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String mess = dis.readUTF();
		System.out.println(mess);
 
		bos.close();
		server.close();
	}
}
