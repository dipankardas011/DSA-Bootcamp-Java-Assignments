package Easy;

public class Q14 {
    public int[] sortedSquares(int[] nums) {
        int end = nums.length-1;
        int start = 0;
        int[] ans = new int[nums.length];
        int pos = nums.length-1;

        while (pos >= 0) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                ans[pos] = nums[start]*nums[start];
                start++;
            } else {
                ans[pos] = nums[end]*nums[end];
                end--;
            }
            pos--;
        }

        return ans;
    }
}
