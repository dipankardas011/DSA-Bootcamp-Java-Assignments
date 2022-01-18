package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
//    int counter;
//
//    private void util(int[] nums,
//                      int i,
//                      int currSum,
//                      int target) {
//        if (i == nums.length) {
//            if (currSum == target)
//                counter++;
//            return;
//        }
//
//        util(nums, i+1, currSum+nums[i], target);
//        util(nums, i+1, currSum-nums[i], target);
//    }
//
//    public int findTargetSumWays(int[] nums,
//                                 int target) {
//        util(nums,0,0,target);
//        return counter;
//    }
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0,1);
        //  if the target is 0 then value 1
        for (int num : nums) {
            Map<Integer, Integer> dp2 = new HashMap<>();
//            System.out.println(dp); // for the each steps
            for (int j : dp.keySet()) {
                int key1 = j+num;
                dp2.put(
                        key1,
                        dp2.getOrDefault(key1, 0)+dp.get(j)
                );
                int key2 = j-num;
                dp2.put(
                        key2,
                        dp2.getOrDefault(key2, 0)+dp.get(j)
                );
            }
            dp =dp2;
        }
        System.out.println("DPDP: "+dp);
        return dp.getOrDefault(target,0);
    }

    public static void main(String[] args) {
        Q3 o = new Q3();
        System.out.println(o.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
