package Medium;

import java.util.ArrayList;
import java.util.List;

public class Q16 {

    private int cal(int left, char opCode, int right) {
        return switch(opCode) {
            case '*'-> left*right;
            case '+' -> left+right;
            case '-' -> left-right;
            default -> throw new IllegalStateException("Unexpected value: " + opCode);
        };
    }


    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '*' || ch == '+' || ch == '-') {
                List<Integer> leftAns = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rightAns = diffWaysToCompute(expression.substring(i+1));

                for (Integer l1 : leftAns) {
                    for (Integer l2 : rightAns) {
                        res.add(cal(l1,ch,l2));
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }

    public static void main(String[] args) {
        Q16 o = new Q16();
        System.out.println(o.diffWaysToCompute("2-1-1"));
        System.out.println(o.diffWaysToCompute("2*3-4*5"));
    }
}