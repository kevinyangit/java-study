package lang;

import org.junit.Test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.level.Level;

public class GotoLabelTest {

	static Log log = LogFactory.get();

	@Test
	public void test() {
		demo();
	}

	public  static void demo(){
		Level TAG = Level.DEBUG;
        outer:
        while(true){
            go:
            for(int i=0;i<10;i++){
				log.log(TAG,"i值为："+i);
                if(i==2){
                    inter:
                    for(int j=0;i<3;j++){
                        log.log(TAG,"j值为："+j);
                        if(j==1){
                            log.log(TAG,"j==1跳出inter");
                            break inter;
                        }
                    }
                }
                if(i==3){
                    log.log(TAG,"i==3，继续循环go");
                    continue go;
                }
                if(i==4){
                    log.log(TAG,"i==4，跳出outer");
                    break outer;
                }
            }
        }
    }
}
