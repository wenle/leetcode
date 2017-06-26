import java.util.*;

/**
 * date 17/3/9
 *
 * @author wenle
 * @see https://leetcode.com/problems/3sum/?tab=Description
 */
public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i=0;i<nums.length-2;i++) {

            if(nums[i] > 0) {
                break;
            }
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j=i+1;
            int k=nums.length -1;
            while(j<k) {

                int sum = nums[j] + nums[k] + nums[i];
                if(sum > 0) {
                    while(j<k && nums[k-1] == nums[k]){
                        k--;
                    }
                    k--;
                } else if(sum < 0) {
                    while(j<k && nums[j+1] == nums[j]){
                        j++;
                    }
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<k && nums[k-1] == nums[k]){
                        k--;
                    }
                    k--;
                    while(j<k && nums[j+1] == nums[j]){
                        j++;
                    }
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);

        nums = new int[]{-3, 1, 1, 2, 2};
        lists = threeSum.threeSum(nums);
        System.out.println(lists);

    }
}
