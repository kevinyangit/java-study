package ioc;

import java.net.URL;

/**资源加载器
 * @author guangfeng.yang
 *
 */
public class ResourceLoader  {
	
	 /**
	   * 给定一个位置， 使用累加器的资源加载URL，并创建一个“资源URL”对象，便于获取输入流
	   */
	  public ResourceUrl getResource(String location) {
	    URL url = this.getClass().getResource(location);
	    return new ResourceUrl(url);
	  }
}
