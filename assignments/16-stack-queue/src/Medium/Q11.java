package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q11 {
    public int[] calculateSpan(int price[], int n) {
        // Your code here
        Stack<Integer> a=new Stack<Integer>();
        int[] b=new int[n];
        b[0]=1;
        a.push(0);
        for(int i=1;i<n;i++)
        {
            while(!a.isEmpty()&& price[i]>=price[a.peek()])
                a.pop();

            if(a.isEmpty())
                b[i]=i+1;
            else
                b[i]=i-a.peek();

            a.push(i);

        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q11().calculateSpan(new int[]{100,80,60,70,60,75,85}, 7)));
        System.out.println(Arrays.toString(new Q11().calculateSpan(new int[]{10, 4, 5, 90, 120, 80}, 6)));
    }
}
