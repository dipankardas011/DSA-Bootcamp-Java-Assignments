package Easy;

public class Q19 {

    public int maxRepeating(String sequence, String word) {

        StringBuilder str = new StringBuilder(word);
        int ans = 0;
        while (sequence.contains(str.toString())) {
            ans++;
            str.append(word);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q19 ob = new Q19();
        System.out.println(ob.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}