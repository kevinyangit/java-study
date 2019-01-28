package lombok;

public class People {
	//初始化，天生就是master
	private final static String MASTER = "杨光锋";
	//可选 奴隶
	private String sexSlave = "";
	private void fuck() {
			System.out.println("主人: " + MASTER + "fuck: " + "性奴: " + this.sexSlave);
			System.out.println("性奴: " + this.sexSlave + "很开心");
	}
	public static void main(String[] args) {
		People people = new People();
		people.sexSlave("游滨华");
		for (int i = 1; i < 100; i++) {
			System.out.printf("第%s次\n", i);
			people.fuck();
		}
	}
	private void sexSlave(String string) {
		this.sexSlave=string;
	}
}
