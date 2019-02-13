package ioc;

import java.io.InputStream;

/**资源定义
 * @author Administrator
 *
 */
public interface Resource {
	 /**
	   * 获取输入流
	   */
	  InputStream getInputstream() throws Exception;
}
