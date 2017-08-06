package jianzhioffer;

import java.util.*;

/**
 * date 17/8/6
 *
 * @author wenle
 */
public class Question33 {

    public static void printSmallestCombination(List<Integer> nums) {

        nums.sort((o1, o2) -> {

            String sum1 = o1.toString() + o2.toString();
            String sum2 = o2.toString() + o1.toString();
            for (int i = 0; i < sum1.length(); i++) {
                if (sum1.charAt(i) > sum2.charAt(i)) {
                    return 1;
                } else if (sum1.charAt(i) < sum2.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            builder.append(nums.get(i));
        }
        System.out.println(builder.toString());

    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(32);
        nums.add(321);
        printSmallestCombination(nums);
    }

}
