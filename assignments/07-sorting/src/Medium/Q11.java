package Medium;

public class Q11 {
    public static int findDuplicate(int[] nums) {
        // count sort
        // number are 1....nums.length-1
        // so if the index +1 is the number move forward
        int iter = 0;
        while (iter < nums.length) {
            if (iter + 1 != nums[iter]) {
                if (nums[iter] != nums[nums[iter] - 1]) {
                    int t = nums[nums[iter] - 1];
                    nums[nums[iter] - 1] = nums[iter];
                    nums[iter] = t;
                } else {
                    return nums[iter];
                }
            } else {
                iter++;
            }
        }


        return -1;
    }
}
