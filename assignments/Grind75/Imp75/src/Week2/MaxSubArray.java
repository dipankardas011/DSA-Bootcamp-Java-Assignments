package Week2;

public class MaxSubArray {
    //Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            sum += i;
            max = Math.max(max, sum);
            // if sum becomes less than 0 then reset it
            sum = sum < 0  ? 0 : sum;
        }
        return max;
    }
}
