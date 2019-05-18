package basic;

public class SwitchWithoutBreak {
    public static void main(String[] args) {
//        System.out.println("test");
        int i = 1;
        switch (i) {
            case 0:
                System.out.println("test");
//                break;
            case 1:
                System.out.println("1");
                //如果没有break的话，那会继续判断后面的值。
                //break;
            case 2:
                System.out.println("2");
//                break;
            default:
                System.out.println("default");
        }

    }
}
