package divide;

public class DivideAndMod {

	public static void main(String[] args) {
		System.out.println("取余" +  (-9) % (2));
		System.out.println("取余" +  (-9) % (-2));
		System.out.println("取余" +  (9) % (-2));
		System.out.println("取余" +  (9) % (2));
		System.out.println("取模" + Math.floorMod(-9, 2));
		

		/*
		 * 取余的结果和被除数同号，取模的结果和除数同号
		 * 
		 * 
		 * 取模：这里Math.floorMod方法的功能是向下取模（也就是取模）。
		 * “向下”的意思就是说尽可能让商更小（商值向负无穷方向取）。
		 * 如-9mod2，-9/2=-4.5，取商为-5。余数为-9-（2*-5）=1。
		取余：尽可能让商的绝对值更小【向0值方向取】。
		如-9rem2，-9/2=-4.5，取商为-4,。余数为-9-（2*-4）=-1。
		 * 
		 * a被除数， b是除数， q是商， r是余数
		 * r = a - (b*q)
		 * 一般人不做区分
		 * 教程：https://zhuanlan.zhihu.com/p/39389916
		 */
	}
}
