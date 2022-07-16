package Medium;

import java.util.Stack;

public class Q14 {
    long getMaxArea(long[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++) {
            while(st.size()!=0 && arr[i]<=arr[st.peek()])
                st.pop();
            left[i]= st.size()!=0?st.peek()+1:0;
            st.push(i);
        }

        while(st.size()!=0) st.pop();

        for(int i=n-1;i>=0;i--) {
            while(st.size()!=0 && arr[i]<=arr[st.peek()])
                st.pop();

            right[i]=st.size()!=0?st.peek()-1:n-1;
            st.push(i);
        }

        long mx=0;
        for(int i=0;i<n;i++) {
            long curr_area=(right[i]-left[i]+1)*arr[i];
            mx=Math.max(mx,curr_area);
        }
        return mx;
    }

    public static void main(String[] args) {
        System.out.println(new Q14().getMaxArea(new long[]{6,2,5,4,5,1,6},7));
    }
}
