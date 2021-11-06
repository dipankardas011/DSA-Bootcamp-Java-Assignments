package Easy;

public class Q21 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] hash = new int[101];

        for (int num : nums) {
            hash[num]++;
        }
        for (int i = 1; i < 101; i++) {
            hash[i] += hash[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            int pos = nums[i];
            nums[i] = (pos==0) ? 0 : hash[pos-1];
        }
        return nums;
    }
}
