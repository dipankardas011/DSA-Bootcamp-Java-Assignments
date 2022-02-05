package Medium;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] hashForNumber = {
            "","",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private List<String> utility(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            List<String> ll = new ArrayList<>();
            ll.add(processed);
            return ll;
        }
        List<String> res = new ArrayList<>();
        int digit = unprocessed.charAt(0) - '0';
        String ss = hashForNumber[digit];
        for (char ch : ss.toCharArray()) {
            res.addAll(utility(processed+ch, unprocessed.substring(1)));
        }
        return res;
    }

    public List<String> letterCombinations(String word) {
        if (word.isEmpty())
            return new ArrayList<>();
        List<String> res = new ArrayList<>(utility("", word));
        return res;
    }


    public static void main(String[] args) {
        Q17 o =new Q17();
        System.out.println(o.letterCombinations("23"));
    }
}