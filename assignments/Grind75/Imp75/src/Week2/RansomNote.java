package Week2;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> r = new HashMap<>();
        HashMap<Character, Integer> m = new HashMap<>();

        for (Character ch : magazine.toCharArray()) {
            if (m.containsKey(ch)) {
                m.put(ch, m.get(ch)+1);
            } else {
                m.put(ch, 1);
            }
        }

        for (Character ch : ransomNote.toCharArray()) {
            if (r.containsKey(ch)) {
                r.put(ch, r.get(ch)+1);
            } else {
                r.put(ch, 1);
            }
        }

        for (char ch = 'a' ; ch <= 'z'; ch++) {
            if (r.containsKey(ch)){
                if (m.containsKey(ch)) {
                    if (r.get(ch) > m.get(ch))
                        return false;
                } else {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a", "b"));
        System.out.println(new RansomNote().canConstruct("aa", "ab"));
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
        System.out.println(new RansomNote().canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}
