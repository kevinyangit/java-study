package files;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class FileTest {
	@Test
	public void newFile() throws IOException{
		File file = new File("c:/a.txt");
		boolean exists = file.exists();
		System.out.println("");
	}
	@Test
	public void newCreateFile() throws IOException{
		File file = new File("c:/a.txt");
		boolean exists = file.exists();
		boolean createNewFile = file.createNewFile();
		System.out.println("");
	}
	@Test
	public void newCreateFileIfDirecoryNoExist() throws IOException{
		File file = new File("c:/aa/a.txt");
		boolean exists = file.exists();
		boolean createNewFile = file.createNewFile();
		System.out.println("");
	}
	@Test
	public void newCreateFileIfDirecoryMake() throws IOException{
		File file = new File("c:/aa/a.txt");
		boolean exists = file.exists();
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		boolean createNewFile = file.createNewFile();
		System.out.println("");
	}
	@SuppressWarnings("resource")
	@Test
	public void newOutputStreamIfDirecoryMake() throws IOException{
		File file = new File("c:/aa/b.txt");
		boolean exists = file.exists();
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		System.out.println("");
	}
	@Test
	public void newOutputStreamIfDirecoryNoExist() throws IOException{
		File file = new File("c:/bb/b.txt");
//		boolean exists = file.exists();
//		if(!file.getParentFile().exists()){
//			file.getParentFile().mkdirs();
//		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		System.out.println("");
	}

	@Test
	public void testSlash() throws Exception {
		String str = "/home\\/bqadm";
		File file = new File(str);
		String[] list = file.list();
		System.out.println(list);
	}
}
