package Easy;

public class Q22 {

    private String ReverseIt(String str) {
        StringBuilder s = new StringBuilder(str);
        s.reverse();
        return s.toString();
    }

    public String reversePrefix(String word, char ch) {
        int s = 0;
        int e = 0;
        int i;
        for (i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                e = i;
                break;
            }
        }
        if (i == word.length() && e == 0) {
            return word;
        } else {
            return ReverseIt(word.substring(s, e + 1)) + word.substring(e + 1);
        }
    }

    public static void main(String[] args) {

    }
}