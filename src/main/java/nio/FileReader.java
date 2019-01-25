package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReader {

	public static void main(String[] args) {
		
//		readChannel();
		readWhileChannel();
	}

	private static void readWhileChannel()
	{
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile("I:/neonworkspace/study/src/com/nio/file/a.txt","rw");
			FileChannel channel = randomAccessFile.getChannel();
			ByteBuffer allocate = ByteBuffer.allocate(64);
			while( -1 != channel.read(allocate))
			{
				allocate.flip();
				while (allocate.hasRemaining()) {
					System.out.print((char)allocate.get());
				}
				allocate.clear();
			}
			randomAccessFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void readChannel() {
		try {
			RandomAccessFile aFile = new RandomAccessFile("I:/neonworkspace/study/src/com/nio/file/a.txt", "rw");
			FileChannel inChannel = aFile.getChannel();
			//create buffer with capacity of 48 bytes
			ByteBuffer buf = ByteBuffer.allocate(48);
			int bytesRead = inChannel.read(buf); //read into buffer.
			while (bytesRead != -1) {
				buf.flip();  //make buffer ready for read
				while(buf.hasRemaining()){
					System.out.print((char) buf.get()); // read 1 byte at a time
				}
				buf.clear(); //make buffer ready for writing
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
