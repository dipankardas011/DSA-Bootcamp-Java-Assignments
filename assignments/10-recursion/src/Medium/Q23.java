package Medium;

public class Q23 {

    private int utility(int[] freqLetters) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (freqLetters[i] == 0)
                continue;
            sum++;
            freqLetters[i]--; // used
            sum += utility(freqLetters);
            freqLetters[i]++; // marke as unused
        }
        return sum;
    }

    public int numTilePossibilities(String titles) {
        int[] count = new int[26];
        for (char ch : titles.toCharArray())
            count[ch-'A']++;
        return utility(count);
    }

    public static void main(String[] args) {
        System.out.println("Ans: "+new Q23().numTilePossibilities("AAB"));
    }
}