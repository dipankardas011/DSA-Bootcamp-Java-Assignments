package Medium;

public class Q15 {
    //One pass to count suffix sum of shifts.
    //One pass to shift letters in string S
    public String shiftingLetters(String s, int[] shifts) {
        for (int i=s.length() -2 ; i>= 0; i--)
            shifts[i] = (shifts[i+1] + shifts[i])%26;

        StringBuilder res = new StringBuilder(s);
        for (int i=0; i<s.length(); i++) {
            int x = s.charAt(i) - 'a' + shifts[i];
            res.setCharAt(i, (char)(x%26 + 'a'));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Q15 o = new Q15();
        System.out.println(o.shiftingLetters("z", new int[]{52}));
    }
}
