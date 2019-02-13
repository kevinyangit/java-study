package txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader {

	@SuppressWarnings({ "resource", "null" })
	public static void main(String[] args) throws IOException {
		String path = "C:/Users/guangfeng.yang/Desktop/atr.log";
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String readLine = null;
		int i = 0;
		while ((readLine = bufferedReader.readLine()) !=null) {
			boolean contains = readLine.contains("的逾期日期为空值，请与核心检查此合同的情况");
			if(contains){
				i++;
				int index = readLine.indexOf("合同号[")+4;
				String substring = readLine.substring(index, readLine.lastIndexOf("]"));
				System.out.println(substring);
			}
		}
		System.out.println("count: " + i);
	}

}
