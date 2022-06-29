package Medium;

import java.util.Stack;

public class Q5 {
    public boolean find132pattern(int[] nums) {
        int num3 = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for (int i= nums.length-1; i>=0; i--) {
            // if the nums[i] < num3 like num1 < num3 < num2
            if (nums[i] < num3)
                return true;
            // find the last popped number as num3 is second highest after num2
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                num3 = stk.pop();
            }

            // insert into the stack
            stk.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q5().find132pattern(new int[]{3,1,4,2}));
        System.out.println(new Q5().find132pattern(new int[]{1,2,3,4}));
    }
}
