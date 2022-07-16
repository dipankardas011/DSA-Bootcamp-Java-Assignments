package Medium;

import java.util.Stack;

public class Q13 {
    int findCelebrity(int[][] M) {
        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<M.length; i++)
            stk.push(i);

        while (stk.size() > 1) {
            int a = stk.pop();
            int b = stk.pop();
            if (M[a][b] == 1)
                stk.push(b);
            else
                stk.push(a);
        }
        if (stk.isEmpty())
            return -1;

        int res = stk.pop();
        for (int i=0; i<stk.size();i++){
            if (res != i && (M[res][i] == 1 || M[i][res] != 0))
                return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q13().findCelebrity(new int[][]{{0,1,0},{0,0,0},{0,1,0}}));
    }
}
