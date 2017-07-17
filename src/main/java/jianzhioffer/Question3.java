package jianzhioffer;

/**
 * date 17/7/17
 *
 * @author wenle
 */
public class Question3 {

    public static boolean contains(int[][] x, int num) {

        int len = x.length;

        int i = len -1;
        int j = 0;

        while(i>=0 && j<len) {

            int current = x[i][j];
            if(current == num) {
                System.out.println("Contains: " + num);
                return true;
            } else if(current > num) {
                i--;
            } else {
                j++;
            }
        }
        System.out.println("NOT contains: " + num);
        return false;
    }

    public static void testContains(int[][] x, int num) {

    }

    public static void main(String[] args) {

        int[][] x = new int[][] {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        contains(x, 9);
        contains(x, 10);
        contains(x, 5);
        contains(x, 100);

    }

}
