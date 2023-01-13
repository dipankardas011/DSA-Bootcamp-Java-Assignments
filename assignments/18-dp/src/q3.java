package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class q3 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(new Stack<>(), 0,0, n,res);
        return res;
    }
    private void backtracking(Stack<String> stk, int openBalance, int closeBalance, int N, List<String> ans) {
        if (openBalance == closeBalance && openBalance == N) {
            StringBuilder abcd = new StringBuilder();
            for (String str : stk.stream().toList() ){
                abcd.append(str);
            }
            ans.add(abcd.toString());
            return;
        }
        if (openBalance < N) {
            stk.add("(");
            backtracking(stk, openBalance+1, closeBalance, N, ans);
            stk.pop();
        }
        if (closeBalance < openBalance) {
            stk.add(")");
            backtracking(stk, openBalance, closeBalance+1, N, ans);
            stk.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new q3().generateParenthesis(1));
        System.out.println(new q3().generateParenthesis(3));
    }
}
