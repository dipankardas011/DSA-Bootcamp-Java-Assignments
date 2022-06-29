package Medium;

import java.util.Objects;
import java.util.Stack;

public class Q3 {
    public String decodeString(String s) {
        Stack<Integer> coeff = new Stack<>();
        Stack<String> brack = new Stack<>();
        int number = 0;

        StringBuilder ans = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (Integer.valueOf(c)-'0');
            } else {
                if (number > 0)
                    coeff.push(number);
                number = 0;
                if (Character.isAlphabetic(c)) {
                    brack.push(c+"");
                } else {
                    if (c == '[')
                        brack.push(c+"");
                    else {
                        StringBuilder str = new StringBuilder();
                        while (!brack.peek().equals("[")) {
                            str.append(brack.pop());
                        }
                        brack.pop();
                        String x =str.toString();
                        int repeat=coeff.pop();
                        StringBuilder rep = new StringBuilder();
                        while (repeat-- > 0){
                            rep.append(x);
                        }
                        brack.push(rep.toString());
                    }
                }
            }
        }
        while (!brack.isEmpty())
            ans.append(brack.pop());
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q3().decodeString("3[a]2[bc]"));
        System.out.println(new Q3().decodeString("3[a2[c]]"));
        System.out.println(new Q3().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Q3().decodeString("100[leetcode]"));
    }
}
