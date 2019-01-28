
package hutool.cache;
import java.util.Date;
import java.util.Iterator;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateUtil;

/**
 * Hello world!
 *
 */
public class CacheTest 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
        fifoCache.put("1", "a");
        fifoCache.put("2", "b");
        fifoCache.put("3", "c");
        fifoCache.put("4", "d");
        boolean full = fifoCache.isFull();
        System.out.println("full : " +  full);
        Iterator<String> iterator = fifoCache.iterator();
        while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
        
        Date date = DateUtil.date();

    }
    
}
