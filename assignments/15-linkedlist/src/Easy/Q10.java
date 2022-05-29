package Easy;

import java.util.ArrayList;
import java.util.List;

public class Q10 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int idx = 0;
        while (idx < nums.length) {
            int correctIdx = nums[idx] - 1;
            if (nums[correctIdx] != nums[idx]) {
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[idx];
                nums[idx] = temp;
            } else {
                idx++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)
                list.add(i+1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Q10().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
