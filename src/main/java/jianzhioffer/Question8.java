package jianzhioffer;

/**
 * date 17/7/19
 *
 * @author 柏霜
 */
public class Question8 {

    public static int min(int[] rotateIncArray) {

        int len = rotateIncArray.length;
        int p = 0;
        int q = len - 1;
        if (rotateIncArray[p] <= rotateIncArray[q]) {
            return rotateIncArray[p];
        }

        while (q - p > 1) {
            int mid = (p + q) / 2;
            if (rotateIncArray[p] < rotateIncArray[mid]) {
                p = mid;
            } else {
                q = mid;
            }
        }

        return rotateIncArray[q];
    }

    public static void main(String[] args) {

        int[] case1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(min(case1));
        int[] case2 = new int[]{3, 4, 5, 1, 2};
        System.out.println(min(case2));
        int[] case3 = new int[]{1};
        System.out.println(min(case3));
        int[] case4 = new int[]{1, 2};
        System.out.println(min(case4));
    }

}
