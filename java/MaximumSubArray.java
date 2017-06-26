/**
 * date 17/6/10
 *
 * @see https://leetcode.com/problems/maximum-subarray/#/description
 * @author 柏霜
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int [] maxSubArrayEnding = new int[nums.length];
        maxSubArrayEnding[0] = nums[0];
        int max = maxSubArrayEnding[0];
        for(int i=1;i<nums.length;i++) {
            maxSubArrayEnding[i] =  maxSubArrayEnding[i-1] > 0 ? maxSubArrayEnding[i-1] + nums[i] : nums[i];
            max = Math.max(max, maxSubArrayEnding[i]);
        }
        return max;
    }

}
