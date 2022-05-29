package Hard;

public class Q2 {
    public int findMin(int[] nums) {
        // find the index  of the pivot with duplicates
        int largest = pivotFinder(nums);
        if (largest == -1){
            return nums[0];
        }
        return nums[largest+1];
    }

    public int pivotFinder(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) /2;

            if (mid < end && nums[mid] > nums[mid + 1])
                return mid;
            if (mid > start && nums[mid] < nums[mid - 1])
                return mid - 1;

            if (nums[mid] == nums[start] && nums[end] == nums[mid]) {

                if (start < end && nums[start] > nums[start+1])
                    return start;
                start++;

                if(start < end && nums[end] < nums[end-1])
                    return end -1;
                end--;
            }
            else if(nums[start] < nums[mid] || nums[start]==nums[mid] && nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q2().findMin(new int[]{3,3,3,1}));
    }
}
