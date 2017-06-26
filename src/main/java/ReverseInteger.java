/**
 * date 17/6/26
 *
 * @author wenle
 * @see https://leetcode.com/problems/reverseBad-integer/#/description
 */
public class ReverseInteger {


    public int reverseBad(int x) {

        String str = String.valueOf(x);
        int len = str.length();
        char[] array = str.toCharArray();
        int begin = len - 1;
        while (begin >= 0) {  // remove trailing zero
            if (array[begin] != '0') {
                break;
            }
            begin--;
        }
        if (begin < 0) {
            return 0;
        }

        int num = 0;
        for (int i = begin; i >= 0; i--) {
            char c = array[i];
            if (c == '-') {
                return -num;
            }
            int digit = array[i] - '0';
            if (Integer.MAX_VALUE / 10 < num) {
                return 0;
            }
            if (Integer.MAX_VALUE - num * 10 < digit) {
                return 0;
            }
            num = num * 10 + digit;
        }
        return num;
    }

    public int reverse(int x) {

        int result = 0;
        while(x != 0) {

            int tail = x % 10;
            int temp = result * 10 + tail;
            if((temp - tail) / 10 != result) {
                return 0;
            }
            result = temp;
            x = x/10;
        }
        return result;
    }

    public void printResult(int x) {

        System.out.println("INPUT: " + x);
        System.out.println("OUTPUT: " + this.reverse(x));
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.printResult(Integer.MAX_VALUE);
        reverseInteger.printResult(Integer.MIN_VALUE);
        reverseInteger.printResult(12345);
        reverseInteger.printResult(-5678);
        reverseInteger.printResult(-123000);
        reverseInteger.printResult(0);

        System.out.println("-6%10: " + ((-6)%10));
        System.out.println("-66%10: " + ((-66)%10));
        System.out.println("-66/10: " + ((-66)/10));
    }
}
