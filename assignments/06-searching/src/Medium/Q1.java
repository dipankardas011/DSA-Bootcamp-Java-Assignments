package Medium;

import java.util.Arrays;

public class Q1 {
    public int[] searchRange(int[] nums, int target) {
        // sorted arr is binary search
        int[] ans = new int[]{-1,-1};
        ans[0] = binarySearch(nums, target, true);
        if (ans[0] != -1)
            ans[1] = binarySearch(nums, target, false);
        return ans;
    }
    public int binarySearch (int[] arr, int target, boolean searchFirst) {
        int start = 0;
        int end = arr.length-1;
        int pos = -1;

        while (start<=end) {
            int mid = start + (end-start)/2;
            if (arr[mid] == target) {
                pos = mid;
                if (searchFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                end = mid -1 ;
            } else {
                start = mid +1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Q1 o = new Q1();
        System.out.println(Arrays.toString(o.searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
}
