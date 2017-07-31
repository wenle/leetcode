package jianzhioffer;

/**
 * date 17/7/23
 *
 * @author wenle
 */
public class Question10 {


    public static int countBit1InNumber(int x) {

        int y = 1;
        int count = 0;
        while (true) {
            if ((x & y) > 0) {
                count++;
            }
            if (y == 0) { // 左移到头
                if (x < 0) {
                    count++;
                }
                break;
            }
            y = y << 1;
        }
        return count;
    }

    public static int countBit1InNumber2(int x) {

        int count  = 0;
        while(x != 0) {
            count ++;
            x = x & (x-1);
        }
        return count;
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 7, -1, Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int n : numbers) {

            System.out.println("count of bit 1 in number " + n + ": " + countBit1InNumber(n));
            System.out.println("count2 of bit 1 in number " + n + ": " + countBit1InNumber2(n));
        }

    }

}
