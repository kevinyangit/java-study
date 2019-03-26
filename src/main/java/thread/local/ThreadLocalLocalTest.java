package thread.local;

public class ThreadLocalLocalTest {

	public static void main(String[] args) throws InterruptedException {
		
		TransferLocal transfer = new TransferLocal();
		
		Thread thread = new Thread(transfer);
		thread.start();
		Thread thread2 = new Thread(transfer);
		thread2.start();
		
		thread.join();
		thread2.join();
		//这里为什么是返回是初始化的值 ，因为他是main线程的值
		System.out.println(transfer.get());

	}

}
