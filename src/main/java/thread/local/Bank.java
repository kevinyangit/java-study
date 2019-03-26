package thread.local;

public class Bank {

	ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 100;
		};
	};
	public void set() {
		t.set(t.get() + 10);
	};
	public Integer get() {
		return t.get();
	};
}
