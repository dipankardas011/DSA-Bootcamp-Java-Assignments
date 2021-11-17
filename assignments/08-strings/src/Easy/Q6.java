package Easy;

import java.util.Arrays;

public class Q6 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();
        for(String ww : word1){
            w1.append(ww);
        }

        for(String ww:word2){
            w2.append(ww);
        }

        return (w1.toString()).compareToIgnoreCase(w2.toString()) == 0;
    }

    public static void main(String[] args) {
        Q6 o = new Q6();
        String[] w1 = {"ab", "c"};
        String[] w2 = {"a", "bc"};
        System.out.println(o.arrayStringsAreEqual(w1,w2));
    }
}
