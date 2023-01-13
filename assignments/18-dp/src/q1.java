package src;

public class q1 {
    public boolean isSubsequence(String s, String t) {
        int j = 0;

        for(int i=0;j<s.length()  && i<t.length();i++) {
            if(s.charAt(j) == t.charAt(i))
                j++;
        }

        return j==s.length();
    }
}