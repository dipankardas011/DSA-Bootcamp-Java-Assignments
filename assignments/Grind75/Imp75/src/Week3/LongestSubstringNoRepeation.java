package Week3;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringNoRepeation {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> store = new HashMap<>();
        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (store.containsKey(s.charAt(i))) {
                j = Math.max(j, store.get(s.charAt(i))+1);
            }
            store.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringNoRepeation().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringNoRepeation().lengthOfLongestSubstring("dvdf"));
    }
}
