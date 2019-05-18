package basic;

public class TryCatchWithReturn {
    public static void main(String[] args) {

//        System.out.println(new TryCatchWithReturn().test());
        System.out.println(new TryCatchWithReturn().test11());
    }

    public int test() {
        int x = 1;
        try {
            x++;
            return x;
            //这里显示return x;他是有复制的变量，后面的执行都不会做，而不是后面的final ++1的值，所以还是2
        } finally {
            ++x;
        }
    }
    public int test11() {
        int x = 1;
        try {
            x++;
            int a = 1/0;
            //这里显示return x;他是有复制的变量，后面的执行都不会做，而不是后面的final ++1的值，所以还是2
            return x;
        } catch (Exception e){
            System.out.println("test");
            x++;
        }finally {
            ++x;
        }
        return x;
    }
}
