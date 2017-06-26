/**
 * date 17/6/10
 *
 * @author 柏霜
 * @see https://leetcode.com/problems/house-robber/#/description
 */
public class HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n]; // dp[i]为从nums[0]到nums[i]选择,且包含nums[i]的最大金额

        dp[0] = nums[0];
        if (n == 1) {
            return dp[0];
        }
        dp[1] = nums[1];
        if (n == 2) {
            return Math.max(dp[0], dp[1]);
        }
        dp[2] = nums[0] + nums[2];

        int max = Math.max(dp[1], dp[2]);

        // 每步最多跳1位或者跳2位
        // 跳3位必然不是最优解
        for (int i = 3; i < n; i++) {

            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int goodAnswer(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
