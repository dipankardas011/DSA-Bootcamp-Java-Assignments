package Other;

import java.util.Arrays;

public class RobHouse {
     int[] memo;
    public int rob(int[] nums) {

//        ---------------------------------------
        /**
         * eleminate the array to 2 variables as 2 are kept track of
         */
        if (nums.length == 0) return 0;
        int prev1 = 0,
                prev2 = 0;

        for (int i : nums) {
            int next = Math.max(prev1, prev2 + i);
            prev2 = prev1;
            prev1 = next;
        }
        return prev1;

//        ---------------------------------------

        /**
         * uses bottom up to eleminate the recusion stack
         */
         if (nums.length == 0) return 0;
         int[] memo = new int[nums.length + 1];
         memo[0] = 0;
         memo[1] = nums[0];
         for (int i = 1; i < nums.length; i++) {
             int val = nums[i];
             memo[i+1] = Math.max(memo[i], memo[i-1] + val);
         }
         return memo[nums.length];
//        ---------------------------------------

        /**
         * used top down approach with rec+mem
         */
        memo = new int[nums.length + 1];
         Arrays.fill(memo, -1);
         return rob(nums, nums.length - 1);
    }
    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0){
            return memo[i];
        }
        int x = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = x;
        return x;
    }
}
