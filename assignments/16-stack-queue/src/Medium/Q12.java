package Medium;

import java.util.Stack;

public class Q12 {
    int Area(int[] histo) {
        int n=histo.length;
        Stack<Integer> st=new Stack<>();
        int maxA = 0;
        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i == n || histo[st.peek()] >= histo[i])){
                int height = histo[st.peek()];
                st.pop();
                int width = i;
                if(!st.isEmpty()) width = i-st.peek()-1;
                maxA = Math.max(maxA, width*height);
            }
            st.push(i);
        }
        return maxA;
    }
    int maxArea(int[][] M) {
        int n = M.length;
        int m=M[0].length;
        int maxA = Area(M[0]);
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++)
                M[i][j] += (M[i][j] == 0) ? 0 : M[i-1][j];
            maxA = Math.max(maxA, Area(M[i]));
        }
        return maxA;
    }

    public static void main(String[] args) {
        System.out.println(new Q12().maxArea(new int[][]{{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}}));
    }
}
