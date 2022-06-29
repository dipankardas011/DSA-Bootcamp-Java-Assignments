package Medium;

import java.util.Stack;

public class Q4 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int num : asteroids){
            while (!stack.isEmpty() && num < 0 && stack.peek() > 0 && stack.peek() < -num)
                stack.pop();
            if(!stack.isEmpty() && num < 0  && stack.peek() == -num)
                stack.pop();
            else if(!stack.isEmpty() && num < 0  && stack.peek() > -num)
                continue;
            else
                stack.push(num);
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size()-1; i>=0 ;i--)
            ans[i] = stack.pop();
        return ans;
    }
}
