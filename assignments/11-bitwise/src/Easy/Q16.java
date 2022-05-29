package Easy;

public class Q16 {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean[] hashFreq = new boolean[26];
        for (char x : allowed.toCharArray()) {
            hashFreq[x - 'a'] = true;
        }
        for (String word : words) {
            boolean flag = false;
            for (char x : word.toCharArray()) {
                if (hashFreq[x - 'a']) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
