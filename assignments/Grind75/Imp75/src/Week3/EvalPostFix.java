package Week3;

import java.util.Stack;

public class EvalPostFix {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        for (String literal : tokens) {
            switch (literal) {
                case "+", "-", "/", "*" -> {
                    String op1 = stk.pop();
                    String op2 = stk.pop();
                    Integer op11 = Integer.parseInt(op1);
                    Integer op22 = Integer.parseInt(op2);
                    // op2 () op1
                    Integer res = 0;
                    switch (literal) {
                        case "*" -> res = op22 * op11;
                        case "/" -> res = op22 / op11;
                        case "-" -> res = op22 - op11;
                        case "+" -> res = op22 + op11;
                    }
                    stk.push(res.toString());
                }
                default -> stk.push(literal);
            }
        }
        return Integer.parseInt(stk.pop());
    }

    public static void main(String[] args) {
        System.out.println(new EvalPostFix().evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(new EvalPostFix().evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(new EvalPostFix().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
