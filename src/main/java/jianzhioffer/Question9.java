package jianzhioffer;

/**
 * date 17/7/19
 *
 * @author 柏霜
 */
public class Question9 {


    public static int fibonacci(int n) {

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        int pre1 = 0;
        int pre2 = 1;
        int i=2;
        while(i++ <= n) {

            int current = pre1 + pre2;
            pre1 = pre2;
            pre2 = current;
        }
        return pre2;
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
    }
}
