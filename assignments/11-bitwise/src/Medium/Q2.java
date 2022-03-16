package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subSet = new ArrayList<>();
        int size = 0;
        subSet.add(new ArrayList<>());
        for (int i = 0; i<nums.length; i++) {
            int start = (i > 0 && nums[i] == nums[i-1]) ? size : 0;
            size = subSet.size();
            for (int j = start; j < size; j++) {
                List<Integer> xx = new ArrayList<>(subSet.get(j));
                xx.add(nums[i]);
                subSet.add(xx);
            }
        }


        return subSet;
    }

    public static void main(String[] args) {
        System.out.println(new Q2().subsetsWithDup(new int[]{1,2,2}));
    }
}
