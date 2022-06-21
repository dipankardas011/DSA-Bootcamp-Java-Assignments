package Easy;

public class Q4 {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int counter = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(' && counter++ > 0)
                str.append(ch);
            else if (ch == ')' && counter-- > 1)
                str.append(ch);
        }
        return str.toString();
    }
}
