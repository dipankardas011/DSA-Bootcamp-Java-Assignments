package Easy;

import java.util.Stack;

public class Q2 {
    public boolean isValid(String s) {
        Stack<Character> exp = new Stack<>();
        int balance = 0;

        for (Character bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                exp.push(bracket);
                balance--;
            } else {
                balance++;
                while (!exp.isEmpty() && !gotIt(bracket, exp.peek())) {
                    exp.pop();
                }

                if (exp.isEmpty())
                    return false;
                else
                    exp.pop();
            }
        }
        return balance == 0;
    }

    private boolean gotIt(Character exp, Character peek) {
        return switch (exp) {
            case ')' -> peek == '(';
            case '}' -> peek == '{';
            case ']' -> peek == '[';
            default -> false;
        };
    }

    public static void main(String[] args) {
        Q2 o = new Q2();
        System.out.println(o.isValid("()"));
        System.out.println(o.isValid("()[]{}"));
        System.out.println(o.isValid("()[]{"));
        System.out.println(o.isValid("(]"));
        System.out.println(o.isValid("(){}}{"));
    }
}
