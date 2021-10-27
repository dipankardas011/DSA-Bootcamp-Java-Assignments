package Medium;

import java.util.Arrays;

public class Q11 {
    public static void main(String[] args) {
        System.out.println(new Q11().minAbsoluteSumDiff(new int[]{1,7,5}, new int[]{2,3,5}));
    }



    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int)1e9+7;

        // Sorted copy of nums1 to use for binary search
        int[] snums1 = nums1.clone();
        Arrays.sort(snums1);

        int maxDiff = 0;
        int pos = 0;
        int newn1 = 0;

        for (int i=0; i<nums2.length; i++) {
            int n2 = nums2[i];
            int origDiff = Math.abs(nums1[i] - n2);


            int floor = arrayFloor(snums1, n2);
            if (floor > Integer.MIN_VALUE) {
                int newDiff = Math.abs(floor - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = floor;
                    maxDiff = diff;
                }
            }

            int ceiling = arrayCeiling(snums1, n2);
            if (ceiling < Integer.MAX_VALUE) {
                // Same as above
                int newDiff = Math.abs(ceiling - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = ceiling;
                    maxDiff = diff;
                }
            }
        }

        if (newn1 > 0) {
            nums1[pos] = newn1;
        }

        int sum = 0;
        for (int i=0; i<nums1.length; i++) {
            sum = (sum + Math.abs(nums1[i] - nums2[i])) % mod;
        }

        return sum;
    }


    //
    // Array versions of TreeSet.floor and TreeSet.ceiling
    //

    // Greatest element less than or equal to val
    private int arrayFloor(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length-1;
        int max = Integer.MIN_VALUE;

        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if (arr[mid] <= val) {
                max = arr[mid];
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return max;
    }

    // Smallest element greater than or equal to val
    private int arrayCeiling(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length-1;
        int min = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if (arr[mid] >= val) {
                min = arr[mid];
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        return min;
    }
}
