package jianzhioffer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * date 17/7/24
 *
 * @author wenle
 */
public class Question14 {

    // 按条件区分数字,将数组排序, 符合规则的在前,不符合的在后
    public static void sortArrayBinary(int[] array, Predicate<Integer> rule) {

        int p = 0;
        int q = array.length - 1;

        while(p < q) {

            while(p<q && rule.test(array[p])) {
                p++;
            }
            while(p < q && !rule.test(array[q])) {
                q--;
            }
            if(p < q) {
                swap(array, p, q);
            }
        }
    }

    private static void swap(int[] array, int x, int y) {

        array[x] = array[x] ^ array[y];
        array[y] = array[x] ^ array[y];
        array[x] = array[y] ^ array[x];
    }

    public static void main(String[] args) {

        int[] testcases = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        sortArrayBinary(testcases, x -> ((x & 0x1) == 1));

        Arrays.stream(testcases).forEach(System.out::println);
    }


}
