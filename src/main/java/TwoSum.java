import java.util.HashMap;
import java.util.Map;

/**
 *
 * @see https://leetcode.com/problems/two-sum/?tab=Description
 * date 17/2/27
 * @author wenle
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // create map suitable for nums without expansion
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {

            int counterpart = target - nums[i];
            if(map.containsKey(counterpart)) {
                int[] result = new int[]{ map.get(counterpart), i};
                return result;
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[] { 1, 5, 2, 4, 6, 3, 7};
        int[] index = new TwoSum().twoSum(nums, 9);
        System.out.println(index[0]);
        System.out.println(index[1]);
    }

}
