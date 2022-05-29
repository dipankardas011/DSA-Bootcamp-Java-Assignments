package Medium;

import java.util.*;

public class Q4 {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            hash[c-'a']--;
        }

        for (int i : hash)
            if (i!=0)
                return false;

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            if (!visited[i]) {
                list.add(strs[i]);
                visited[i] = true;
            } else {
                continue;
            }
            for (int j = i+1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[j], strs[i])) {
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(list);
        }

        return ans;
    }

    /// using the Map efficient ///
    public List<List<String>> groupAnagramsMap(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray())
                ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Q4 o = new Q4();
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(o.groupAnagramsMap(arr));
    }
}
