package Hard;

import java.util.ArrayList;
import java.util.Stack;

public class Q1 {

    /**
     * Use a stack to store chars except ',' and ')';
     * If we find a ')', keep popping out the chars from the stack till find a '('; add the popped-out into a Set.
     * Pop out the operator after popping ')' out, push into stack the corresponding result according to the operator.
     * repeat the above till the end, and the remaining is the result.
     * @param expression
     * @return
     */

    public boolean parseBoolExpr(String expression) {
        Stack<Character> information = new Stack<>();
        for (char ch : expression.toCharArray()) {

            if (ch == ')') {
                ArrayList<Character> ll = new ArrayList<>();
                while (!information.isEmpty() && information.peek() != '(') {
                    ll.add(information.pop());
                }
                information.pop();
                char opcode = information.pop();
                switch (opcode) {
                    case '&' -> {
                        if ((ll.contains('f'))) {
                            information.push('f');
                        } else {
                            information.push('t');
                        }
                    }
                    case '|' -> {
                        if ((ll.contains('t'))) {
                            information.push('t');
                        } else {
                            information.push('f');
                        }
                    }
                    case '!' -> {
                        if ((ll.contains('t'))) {
                            information.push('f');
                        } else {
                            information.push('t');
                        }
                    }
                }
            }
            else if (ch != ',') {
                information.push(ch);
            }
        }
        return information.pop() == 't';
    }

    public static void main(String[] args) {
//        System.out.println(new Q1().parseBoolExpr("!(f)"));
        System.out.println(new Q1().parseBoolExpr("|(f,t)"));
    }
}
