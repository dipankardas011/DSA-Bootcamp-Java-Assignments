package Easy;

import java.util.Arrays;

public class Q2 {
    public int majorityElement(int[] nums) {
        int targetFreq = nums.length / 2;

        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        // find the number of consquentave numbers
        int i=0;
        while(i< nums.length) {
            int j;
            for (j = i+1; j<nums.length && (nums[i]==nums[j]); j++);

            // System.out.printf("i: %d, j: %d\n",i,j);
            if (targetFreq < (j-i))
                return nums[i];
            else
                i = j;
        }
        return -1;
    }
}
