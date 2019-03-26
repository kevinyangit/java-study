package thread.local;

public class TransferLocal implements Runnable {

	private ThreadLocal<Integer> t  = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 200;
		};
	};
	
	public void set(){
		t.set(t.get() + 10);
	}
	public Integer get(){
		return t.get();
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			set();
			System.out.println("thread name " + Thread.currentThread().getName() + "value " + get());
		}
	}

}
