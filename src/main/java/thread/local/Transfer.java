package thread.local;

public class Transfer implements Runnable {

	private Bank bank;
	
	public Transfer(Bank bank) {
		super();
		this.bank = bank;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.set();
			System.out.println("thread name " + Thread.currentThread().getName() + "value " + bank.get());
		}
	}

}
