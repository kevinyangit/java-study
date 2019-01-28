package net;

import java.net.InetAddress;

import org.junit.Test;

public class InetAddressTest {

	@Test
	public void testName() throws Exception {
		InetAddress localHost = InetAddress.getLocalHost();
		String hostName = localHost.getHostName();
		System.out.println(hostName);
		String hostAddress = localHost.getHostAddress();
		byte[] address = localHost.getAddress();
		String canonicalHostName = localHost.getCanonicalHostName();
		System.out.println("");
		
		InetAddress byName = InetAddress.getByName("www.baidu.com");
		System.out.println(byName.getHostName());
		String hostAddress2 = byName.getHostAddress();
		System.out.println(byName);
		InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
		System.out.println(allByName);
		String ip = "14.215.177.38";
		//传的ip的字节错误
//		byte[] addr = ip.getBytes();
//		InetAddress byAddress = InetAddress.getByAddress(addr );
//		System.out.println(byAddress);
		InetAddress byName2 = InetAddress.getByName(ip);
		System.out.println(byName2);
	}
}
