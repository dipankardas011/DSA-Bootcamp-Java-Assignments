package Hard;

import java.util.Stack;

public class Q1 {
//    public boolean isValid(String s) {
//        Stack<Character> exp = new Stack<>();
//        int balance = 0;
//
//        for (Character bracket : s.toCharArray()) {
//            if (bracket == '(') {
//                exp.push(bracket);
//                balance--;
//            } else {
//                balance++;
//                while (!exp.isEmpty() && exp.peek() != '(') {
//                    exp.pop();
//                }
//
//                if (exp.isEmpty())
//                    return false;
//                else
//                    exp.pop();
//            }
//        }
//        return balance == 0;
//    }

//    public int longestValidParentheses(String s) {
//        int max = 0;
//        for (int i=0;i<s.length();i++) {
//            for (int j=i+2; j<=s.length();j+=2) {
//                if (isValid(s.substring(i,j))) {
//                    max = Math.max(max, j-i);
//                }
//            }
//        }
//        return max;
//    }

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (stk.isEmpty())
                    stk.push(i);
                else
                    max = Math.max(max, i - stk.peek());
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new Q1().longestValidParentheses("(())()("));
    }
}
