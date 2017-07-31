package jianzhioffer;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/**
 * date 17/7/31
 *
 * @author wenle
 */
public class Question22 {

    public static boolean isValidPopSequence(int[] pushSequence, int[] popSequence) {

        if(pushSequence == null || pushSequence.length == 0
                || popSequence == null || popSequence.length == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        for(Integer popItem : popSequence) {

            if(!stack.empty() && Objects.equals(stack.peek(), popItem)) {
                stack.pop();
                continue;
            }

            while(pushIndex < pushSequence.length && pushSequence[pushIndex] != popItem) {
                stack.push(pushSequence[pushIndex]);
                pushIndex++;
            }
            if(pushIndex == pushSequence.length) {
                return false;
            } else {
                pushIndex++;
            }
        }
        return true;
    }

    private static String getStr(int[] array) {

        StringBuilder builder = new StringBuilder("[");
        for(int i=0;i<array.length;i++) {
            builder.append(array[i]);
            if(i<array.length-1) {
                builder.append(',');
            }
        }
        builder.append(']');
        return builder.toString();
    }

    private static void test(int[] pushSequence, int[] popSequence) {

        System.out.println("Push sequence: " + getStr(pushSequence));
        System.out.println("Pop sequence: " + getStr(popSequence));
        System.out.println("match: " + isValidPopSequence(pushSequence, popSequence));
    }

    public static void main(String[] args) {

        test(new int[]{}, new int[]{});
        test(new int[]{1}, new int[]{1});
        test(new int[]{1, 2, 3, 4, 5}, new int[]{3, 2, 4, 1, 5});
        test(new int[]{1, 2, 3, 4, 5}, new int[]{2, 5, 3, 4, 1});
    }
}
