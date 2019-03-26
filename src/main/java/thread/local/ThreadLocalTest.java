package thread.local;

public class ThreadLocalTest {

	public static void main(String[] args) throws InterruptedException {
		
		Bank bank = new Bank();
		Transfer transfer = new Transfer(bank);
		
		Thread thread = new Thread(transfer);
		thread.start();
		Thread thread2 = new Thread(transfer);
		thread2.start();
		
		thread.join();
		thread2.join();
		
		System.out.println(bank.get());

	}

}
