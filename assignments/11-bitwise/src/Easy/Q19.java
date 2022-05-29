package Easy;

import java.util.HashSet;

public class Q19 {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";
        HashSet<Character> hSet = new HashSet<>();

        for (char c : s.toCharArray())
            hSet.add(c);

        for (int i = 0; i < s.length(); i++) {
            if (hSet.contains(Character.toLowerCase(s.charAt(i))) &&
                    hSet.contains(Character.toUpperCase(s.charAt(i))))
                continue;
            String sLeft = longestNiceSubstring(s.substring(0,i));
            String sRight = longestNiceSubstring(s.substring(i+1));
            return (sLeft.length() >= sRight.length()) ? sLeft : sRight;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Q19().longestNiceSubstring("YazaAay"));
        System.out.println(new Q19().longestNiceSubstring("Bb"));
        System.out.println(new Q19().longestNiceSubstring("c"));
    }
}
