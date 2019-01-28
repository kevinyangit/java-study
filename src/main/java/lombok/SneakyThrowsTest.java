package lombok;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;
import lombok.SneakyThrows;

public class SneakyThrowsTest {
	@SneakyThrows
	public static void main(String[] args) {
		
		String hostname = "10.83.22.140";
		int port = 21;
		String username = "adp_user6";
		String password = "os1ojXb6VLj2Pbvc";

		// 匿名登录（无需帐号密码的FTP服务器）
		Ftp ftp = new Ftp(hostname,port,username,password);
		FTPClient client = ftp.getClient();
		 client.enterLocalPassiveMode();
//		client.settimeout
		// 进入远程目录
//		ftp.cd("/opt/upload");
		// 上传本地文件
//		ftp.upload("/opt/upload", FileUtil.file("e:/test.jpg"));
		// 下载远程文件
		ftp.download("/HNGZ/2_BACK/DEBT_RIGHT_TRANSFER/GZ20181026095021182794", "11235278005_证据7：债权转让证明.pdf", FileUtil.file("e:/test2.pdf"));
		ftp.download("/HNGZ/2_BACK/DEBT_RIGHT_TRANSFER/GZ20181026095021182794", "11235278005_证据7：债权转让证明.pdf", FileUtil.file("e:/test3.pdf"));
		ftp.download("/HNGZ/2_BACK/DEBT_RIGHT_TRANSFER/GZ20181026095021182794", "11235278005_证据7：债权转让证明.pdf", FileUtil.file("e:/test4.pdf"));

		// 关闭连接
		ftp.close();
	}
}
