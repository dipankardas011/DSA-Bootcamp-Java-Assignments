package Medium;

/**
 * Q4
 * Split the two sentences into words;
 * Scan the shorter one from left and compare word by word with the longer; Whenever the words from the 2 sentences are not equal, compare the tails of the 2 sentences word by word till the end or they do not match;
 * Confirm if the pointer reaches the end of shorter sentence. If yes, return true; otherwise, return false.
 */
public class Q4 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int i=0;
        sentence1+=" ";
        sentence2+=" ";
        String[] w1=sentence1.split(" ");
        String[] w2=sentence2.split(" ");
        int len1=w1.length, len2=w2.length;

        if(len1 > len2) {
            return areSentencesSimilar(sentence2,sentence1);
        }

        while (i<len1 && w1[i].equals(w2[i])) {
            i++;
        }

        while (i<len1 && w1[i].equals(w2[len2-len1+i])) {
            i++;
        }
        return i == len1;
    }

    public static void main(String[] args) {
        Q4 obj = new Q4();
        System.out.println(obj.areSentencesSimilar("of", "A lot of words"));
    }
}