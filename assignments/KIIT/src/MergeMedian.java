import java.util.ArrayList;

public class MergeMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        // lets take the num1 length  < num2
//
//        if (nums1.length > nums2.length)
//            return findMedianSortedArrays(nums2, nums1);
//        int mergerSize = nums1.length + nums2.length;
//        int middleMerged = mergerSize >> 1;
//        // we binary search using the smallest array to find its middle
//        // then we assume its left part as a part of merged left arr and
//        int left = 0;
//        int right = nums1.length-1;
//        while (true) {
//            int middle = left + (right - left) / 2;
//            int noElementsFromNum2ForLeftSubarray = middleMerged - (middle + 1);
//
//            int j = noElementsFromNum2ForLeftSubarray - 1;
//
//            int num1L = (middle >= 0) ? nums1[middle] : Integer.MIN_VALUE;
//            int num1R = (middle+1 < nums1.length) ? nums1[middle+1] : Integer.MAX_VALUE;
//            int num2L = (j >= 0) ? nums2[j] : Integer.MIN_VALUE;
//            int num2R = (j+1 < nums2.length) ? nums2[j+1] : Integer.MAX_VALUE;
//
//            if (num1L <= num2R && num1R >= num2L) {
//                // odd
//                if ((mergerSize & 1) == 1)
//                    return Math.min(num1R, num2R);
//                    // even
//                else
//                    return (Math.max(num1L, num2L) + Math.max(num2R, num1R)) / 2.0;
//            } else if (num1L > num2R) {
//                right = middle-1;
//            } else {
//                left = middle +1;
//            }
//        }
        ArrayList<Integer> mm = new ArrayList<>();
        int i=0, j=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                mm.add(nums1[i++]);
            else
                mm.add(nums2[j++]);
        }

        while (i < nums1.length)
            mm.add(nums1[i++]);
        while (j < nums2.length)
            mm.add(nums2[j++]);

        double ret = 0.0;
        if ((mm.size() & 1) == 1) {
            // odd
            ret = mm.get(mm.size()/2);
        } else {
            //even
            ret = mm.get(mm.size()/2 - 1) + mm.get(mm.size()/2 );
            ret = ret/2.0;
        }
        return ret;
    }

    public static void main(String[] args) {
        MergeMedian o = new MergeMedian();
        System.out.println(o.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
