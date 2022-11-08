package Week3; 

import java.util.*;

public class Sum3 {

  public List<List<Integer>> threeSum(int[] nums) {
    
    List<List<Integer>> res = new ArrayList<>();

    Arrays.sort(nums);
    HashMap<Integer, Integer> hs = new HashMap<>();
    for (int i=0;i<nums.length; i++) {
      hs.put(nums[i], i);
    }

    for (int i=0;i <nums.length-2; i++) {
      for (int j=i+1; j < nums.length-1; j++) {
        int target = 0 - (nums[i]+nums[j]);
        if (hs.containsKey(target) &&
            hs.get(target) > j) {
          res.add(Arrays.asList(nums[i], nums[j], target));
          j = hs.get(nums[j]);
        }
        i = hs.get(nums[i]);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(new Sum3().threeSum(new int[]{-1,0,1,2,-1,-4}));
  }
}
