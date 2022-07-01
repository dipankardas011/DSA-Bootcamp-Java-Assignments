package Medium;

import java.util.Arrays;
import java.util.Stack;

public class Q7 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q7().mostCompetitive(new int[]{3,5,2,6}, 3)));
    }
}
