package httpclient;


import java.util.HashMap;
import java.util.Map;

public class HandlerFailThread  extends Thread{
    Map<String, String> failUrl=new HashMap<String, String>();
    public void putFailUrl(String url,String status){
        synchronized (failUrl) {
            failUrl.put(url,status);
        }
    }
    @Override
    public void run() {
        while(true){
            
        }
    }
    public void printFailUrl(){
        for(Map.Entry<String, String> m: failUrl.entrySet()){
            System.out.println("****fail:url:"+m.getKey()+ "  code :"+m.getValue());
        }
    }
}