package thread;

public class ThreadMainOut {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                    System.out.println("2000");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("over");
    }
}
