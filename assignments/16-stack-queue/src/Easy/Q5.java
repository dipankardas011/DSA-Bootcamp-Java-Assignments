package Easy;

import java.util.Stack;

public class Q5 {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();

        for (Character character : s.toCharArray()) {
            if (!stk.isEmpty() && character == stk.peek()) {
                stk.pop();
            } else {
                stk.push(character);
            }
        }
        StringBuilder ss = new StringBuilder();
        while (!stk.isEmpty())
            ss.append(stk.pop());
        return ss.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q5().removeDuplicates("abbaca"));
    }
}
