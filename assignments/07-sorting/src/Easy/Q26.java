package Easy;

import java.util.Arrays;

public class Q26 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++){
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            // count = nums.length-i+1;
            if (count == i){
                return i;
            }
        }
        return -1;
    }
}
