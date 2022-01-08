package Medium;

import java.util.Stack;

public class Q10 {
    private boolean isOperator(char ch) {
        return switch (ch) {
            case '+', '-', '*', '/' -> true;
            default -> false;
        };
    }

    private int getPrecedence(char ch) {
        int priority = -1;
//        lower means higher prioirty
        switch (ch) {
            case '/', '*' -> priority=0;
            case '+', '-' -> priority=1;
        }

        return priority;
    }
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        // convert it to the postfix then evaluate
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stk = new Stack<>();

        int iter = 0;
        while (iter < s.length()) {
            if (Character.isWhitespace(s.charAt(iter))) {
                iter++;
                continue;
            }
            if (isOperator(s.charAt(iter))) {

                if (stk.empty()) {
                    stk.push(s.charAt(iter));
                    iter++;
                    continue;
                }
                // ig the () are not involved
                // so only associativity and the precedence that matters
                if (getPrecedence(stk.peek()) > getPrecedence(s.charAt(iter))){
                    stk.push(s.charAt(iter));
                    iter++;
                    continue;
                }

                while(!stk.empty() && getPrecedence(stk.peek()) <= getPrecedence(s.charAt(iter))) {
                    postfix.append(stk.peek());
                    stk.pop();
                }
                stk.push(s.charAt(iter));
            } else {
                // simply insert it
                postfix.append(s.charAt(iter));
            }
            iter++;
        }

        while (!stk.empty()) {
            postfix.append(stk.peek());
            stk.pop();
        }

        System.out.println(postfix);
        stk = null;

        int res = 0;
        Stack<Integer> Cstk = new Stack<>();
        for (char ch : postfix.toString().toCharArray()) {
            if (isOperator(ch)) {
                int A = Cstk.peek();
                Cstk.pop();
                int B = Cstk.peek();
                Cstk.pop();
                int X=0;
                switch (ch) {
                    case '+' -> X = B + A;
                    case '-' -> X = B -A;
                    case '*'->X = B*A;
                    case '/'->X = B/A;
                }
                Cstk.push(X);
            } else {
                Cstk.push(ch-'0');
            }
        }
        res = Cstk.peek();
        Cstk.pop();
        Cstk = null;

        return res;
    }

    private class Solution {
        public int calculateV2(String s) {

            if (s == null || s.isEmpty()) return 0;
            int len = s.length();

            Stack<Integer> stack = new Stack<Integer>();

            int currentNumber = 0;
            char operation = '+';
            for (int i = 0; i < len; i++) {
                char currentChar = s.charAt(i);
                if (Character.isDigit(currentChar)) {
                    currentNumber = (currentNumber * 10) + (currentChar - '0');
                }
                if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                    if (operation == '-') {
                        stack.push(-currentNumber);
                    }
                    else if (operation == '+') {
                        stack.push(currentNumber);
                    }
                    else if (operation == '*') {
                        stack.push(stack.pop() * currentNumber);
                    }
                    else if (operation == '/') {
                        stack.push(stack.pop() / currentNumber);
                    }
                    operation = currentChar;
                    currentNumber = 0;
                }
            }
            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Q10 o = new Q10();
        System.out.println(o.calculate("3+2*2"));
        System.out.println(o.calculate("3+5 / 2"));
        System.out.println(o.calculate("3*5 / 2"));
    }
}
