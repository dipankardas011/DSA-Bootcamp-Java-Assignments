package Hard;

import java.util.*;

public class Q3 {

    private Set<String> util(String xyz) {
        Stack<String> stk = new Stack<>();
        stk.push(xyz);

        Set<String> ans = new HashSet<>();
        while (!stk.isEmpty()) {
            String top = stk.pop();
            if (top.indexOf('{') == -1){
                ans.add(top);
                continue;
            }

            int leftBrac = 0;
            int rightBrac = 0;
            int i = 0;
            while (top.charAt(i) != '}') {
                if (top.charAt(i) == '{')
                    leftBrac = i;
                i++;
            }

            rightBrac = i;

            String leftSide = top.substring(0, leftBrac);
            String rightSide = top.substring(rightBrac+1);
            String[] insideBrackets = top.substring(leftBrac+1, rightBrac).split(",");
            for (String options : insideBrackets) {
                StringBuilder temp = new StringBuilder();
                temp.setLength(0);
                temp.append(leftSide).append(options).append(rightSide);
                stk.push(temp.toString());
            }
        }
        return ans;
    }

    public List<String> braceExpansionII(String expression) {
        Set<String> sets = util(expression);
        List<String> rr = new ArrayList<>(sets.stream().toList());
        Collections.sort(rr);
        return rr;
    }

    public static void main(String[] args) {
        System.out.println(new Q3().braceExpansionII("{a,b}{c,{d,e}}"));
    }
}
