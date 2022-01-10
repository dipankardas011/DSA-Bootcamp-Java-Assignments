package Medium;

import java.util.ArrayList;
import java.util.List;

public class Q18 {

    private boolean isMatch(String query, String pattern) {
        int i = 0;
        for (char c: query.toCharArray()) {
            if (i < pattern.length() && c == pattern.charAt(i))
                i++;
            else if (Character.isUpperCase(c))//check the uppercase has not matched in above condition then false
                return false;
        }
        return i == pattern.length();
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries)
            res.add(isMatch(query, pattern));
        return res;
    }

    public static void main(String[] args) {
        Q18 o =new Q18();
        System.out.println(o.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FB"));
    }
}
