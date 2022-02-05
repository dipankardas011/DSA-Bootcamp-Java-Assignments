package Easy;

public class Q2 {
    public int singleNumber(int[] nums) {
//         xor
        int res = nums[0];
        for (int iter = 1; iter < nums.length; iter++) {
            res ^= nums[iter];
        }
        return res;
    }

}
