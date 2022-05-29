package Medium;

import java.util.Arrays;

public class Q10 {


    public void quickSort(int[] nums, int low, int high) {
        if (low > high)
            return ;
        int s = low;
        int e = high;
        int mid = s + (e - s) /2;
        int pivot = nums[mid];
        // taking the mid as the pivot element
        while(s <= e) {
            while (nums[s] < pivot)
                s++;
            while (nums[e] > pivot)
                e--;
            if (s <= e) {
                swap(nums, s, e);
                s++;
                e--;
            }
        }
        quickSort(nums, low, e);
        quickSort(nums, s, high);
    }


    private void swap(int[] nums, int s, int e) {
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }

    public int findKthLargest(int[] nums, int k) {
        // could use the merge sort or the quick sort
        quickSort(nums, 0, nums.length-1);
//        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
