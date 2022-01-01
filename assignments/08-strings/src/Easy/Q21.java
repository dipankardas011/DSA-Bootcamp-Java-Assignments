package Easy;

public class Q21 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();

        int i = 0;
        int j = 0;
        boolean flag = true;
        while (i < word1.length() && j < word2.length()) {
            if (flag) {
                str.append(word1.charAt(i));
                i++;
                flag = false;
            } else {
                str.append(word2.charAt(j));
                j++;
                flag = true;
            }
        }

        while (i < word1.length()) {
            str.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length()) {
            str.append(word2.charAt(j));
            j++;
        }

        return str.toString();
    }

    public static void main(String[] args) {

    }
}