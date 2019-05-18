package basic;

public class TryTest {

    /**
     * 主要方法
     */
    public static void main(String[] args) {
        // 调用 测试方法
        String result = get();
        // 打印 测试方法返回的结果
         System.out.println(result);
    }

    @SuppressWarnings({"finally", "unused"})
    public static String get() {
        int value = 0;
        try {
            System.out.println("try……");

            //等式1/0 ：分母为0 的明显错误          ——制造错误（用于抛异常）
            int result = 1 / value;

            return "111";

        } catch (Exception e) {
            System.out.println("catch……");
            return "444";
        } finally {
            System.out.println("finally……");
            return "333";
        }

//		return "222";
    }
}
