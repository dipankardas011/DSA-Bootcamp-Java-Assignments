package Easy;

import java.util.Arrays;

public class Q3 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        for (int i = 1; i< nums.length ;i++) {
//            System.out.printf("i: %d\ti-1: %d\n",i,(i-1));
            if (nums[i] == nums[i-1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q3().containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(new Q3().containsDuplicate(new int[]{1,2,3,4}));
    }
}
