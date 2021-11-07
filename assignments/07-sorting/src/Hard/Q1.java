package Hard;

public class Q1 {
    public int firstMissingPositive(int[] nums) {
        // here we are using the cyclic sort
        int index = 0;
        // first sort it
        while (index < nums.length) {
            // here we are going to ignore the -ve and zero
            // element 2 is in index 1 , 3 in 2 so on
            int correctIndex = nums[index] - 1;
            if (nums[index] > 0 && nums[index] <= nums.length && nums[correctIndex] != nums[index]) {
                swap (nums, index, correctIndex);
            } else {
                index++;
            }
        }
        int i;
        // find the smallest missing number
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public void swap(int[] nums, int index, int correctIndex) {
        int t = nums[index];
        nums[index] = nums[correctIndex];
        nums[correctIndex] = t;
    }
}
