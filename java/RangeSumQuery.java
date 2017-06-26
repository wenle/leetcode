/**
 * date 17/6/10
 *
 * @see https://leetcode.com/problems/range-sum-query-immutable/#/description
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * @author 柏霜
 */
public class RangeSumQuery {

    int[] nums;

    public RangeSumQuery(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return nums[j];

        return nums[j] - nums[i - 1];
    }
}
