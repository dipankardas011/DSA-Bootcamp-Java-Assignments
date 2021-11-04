package Easy;

import java.util.Arrays;

public class Q9 {
    public int arrayPairSum(int[] nums) {
        // paring is required
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0;i<nums.length; i+=2)
            sum += nums[i];
        return sum;
    }
}
