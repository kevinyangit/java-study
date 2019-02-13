package ioc;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ResourceLoader  implements Resource{
	/**
	   * 类库URL
	   */
	  private  URL url;

	  /**
	   * 需要一个类库URL
	   */
	  public ResourceLoader(URL url) {
	    this.url = url;
	  }

	  /**
	   * 从URL中获取输入流
	   */
	  @Override
	  public InputStream getInputstream() throws Exception {
	    URLConnection urlConnection = url.openConnection();
	    urlConnection.connect();
	    return urlConnection.getInputStream();
	  }
}
