package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Q1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        Stack<Integer> NG = new Stack<>();
        int iter = nums2.length-1;
        while (iter >= 0) {

            if (iter == nums2.length-1) {
                NG.push(nums2[iter]);
                mapping.put(nums2[iter], -1);
            } else {
                while (!NG.isEmpty() && NG.peek() <= nums2[iter]){
                    NG.pop();
                }
                if (NG.isEmpty()){
                    mapping.put(nums2[iter], -1);
                } else {
                    mapping.put(nums2[iter], NG.peek());
                }
                NG.push(nums2[iter]);
            }

            iter--;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = mapping.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q1().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
