package feature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**新特性
 * @author guangfeng.yang
 *
 */
public class TryWithResourceTest {

	@Test
	public void testTryWithResource() {
		String file = "d:/test.txt";
		try (FileInputStream input = new FileInputStream(file)) {
			int read = input.read();
			byte a = (byte) read;
			byte[] b = { a };
			System.out.println(new String(b, "utf-8"));
			System.out.println(read);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testReadByte() {
		String file = "d:/test.txt";
		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[1024];
			int read = fis.read();
			int i = 0;
			while (-1 != read) {
				buffer[i] = (byte) read;
				read = fis.read();
				i++;
			}
			String string = new String(buffer, "utf-8");
			System.out.println(string.trim());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testReader() {
		try {
			File file = new File("d:/test.txt");
			if (file.isFile() && file.exists()) {
				// 读取的时指定GBK编码格式，若中文出现乱码请尝试utf-8，window默认编码格式为GBK
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String lineTxt = null;
				while ((lineTxt = br.readLine()) != null) {
					System.out.println(lineTxt);
				}
				br.close();
			} else {
				System.out.println("文件不存在!");
			}
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}
	}
	@Test
	public void testByteTooLong(){
		byte[] by = new byte[20];
		by[0] = 102;
		String str = new String(by);
		System.out.println(str);
		
		
		String a = "我";
		byte[] bytes = a.getBytes();
		System.out.println(bytes);
	}
}
