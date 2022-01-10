package Hard;

public class Q3 {
    String lastSubstring(String s) {
        int i = 0, j = 1, k = 0;

        while (j + k < s.length()) {
            if (s.charAt(i+k) == s.charAt(j+k))
                k++;
            else if (s.charAt(i+k) < s.charAt(j+k)) { // this can't be accepted a
                // s our goal is to get the last substring seq where the first must be larger
                // than all the elements after that so this is regected
                i = Math.max(i+k+1, j);
                k = 0;
                j = i+1;
            } else {
                j += k+1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
