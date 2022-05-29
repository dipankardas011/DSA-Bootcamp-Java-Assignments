package Easy;

public class Q8 {
    public int searchInsert(int[] nums, int target) {
        // return the start if the index not found as it the correct place where it must be inserted
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                return mid;
        }
        return start;
    }
}
