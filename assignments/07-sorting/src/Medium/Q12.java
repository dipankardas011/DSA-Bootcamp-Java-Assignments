package Medium;
import java.util.*;
public class Q12 {
    public List<Integer> findDuplicates(int[] nums) {
        // index 0...n-1
        // elements 1..n
        int index = 0;
        while (index < nums.length) {
            int correct = nums[index] - 1;
            if (nums[index] != nums[correct]) {
                swap(nums, index, correct);
            }else{
                index++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1){
                ans.add(nums[i]);
            }
        }

        return ans;
    }
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
