package Medium;

/**
 * Q5
 */
public class Q5 {
    public int repeatedStringMatch(String a, String b) {
        int count=1;
        StringBuilder str = new StringBuilder(a);
        int iter = 0;
        while (iter<b.length() && str.length()<= 10_000) {
            if((str.toString()).contains(b)){
                return count;
            }
            count++;
            str.append(a);
            iter++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Q5 on = new Q5();
        System.out.println(on.repeatedStringMatch("a","aa"));
        System.out.println(on.repeatedStringMatch("abcd","cdabcdab"));
    }
}