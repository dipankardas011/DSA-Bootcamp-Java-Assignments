package Hard;


public class Q6 implements MountainArray{

    public static void main(String[] args) {
        Solution o = new Solution();
//        System.out.println(o.findInMountainArray());
//        arr = new int[]{1,2,3,4,5,3,1};
        // target is 3
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }
}

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int indexPeak = getPeakIndex(mountainArr);
        if (mountainArr.get(indexPeak) == target)
            return indexPeak;
        int ans = 0;
        ans = binarySearch (mountainArr, 0, indexPeak -1, target);
        if (ans != -1)
            return ans;
        return binarySearch (mountainArr, indexPeak + 1, mountainArr.length() - 1, target);
    }
    public int getPeakIndex(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }
    public int binarySearch (MountainArray arr, int start, int end, int target) {
        // since it is a mountain arr so we need to check whether it is ascending / descending
        boolean isAscending = arr.get(end) > arr.get(start);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == target)
                return mid;
            else {
                if (isAscending)
                {
                    if (arr.get(mid) < target)
                        start = mid + 1;
                    else
                        end = mid - 1;
                } else {
                    if (arr.get(mid) < target)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
        }
        return -1;
    }
}