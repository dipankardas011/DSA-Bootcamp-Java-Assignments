public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] hashFreq = new int[26];
        for (int i=0;i<s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            hashFreq[idx]++;
        }

        for (int i=0;i<t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            hashFreq[idx]--;
        }

        for (int i=0; i<26;i++)
            if (hashFreq[i] != 0)
                return false;
        return true;
    }
}
