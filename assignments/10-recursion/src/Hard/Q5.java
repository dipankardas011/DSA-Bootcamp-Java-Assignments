package Hard;

import java.util.Stack;

public class Q5 {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();

        int number = 0, result = 0, sign = +1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number*10 + (ch - '0');
            }
            else if (ch == '+') {
                result += sign * number;

                number = 0;
                sign = +1;
            }
            else if (ch == '-') {
                result += sign * number;

                number = 0;
                sign = -1;
            }
            else if (ch == '(') {
                stk.push(result);
                stk.push(sign);

                result = 0;
                sign = +1;
            }
            else if (ch == ')') {
                result += number*sign;

                result *= stk.pop();
                result += stk.pop();
                number =0;
            }
            else {
                //skip the character when space is there
            }
        }

        if (number != 0)
            result += number*sign;

        return result;
    }
}
