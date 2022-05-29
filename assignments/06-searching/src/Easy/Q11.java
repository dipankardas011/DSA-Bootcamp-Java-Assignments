package Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Q11 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> set = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Q11 o = new Q11();
        System.out.println(Arrays.toString(o.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
