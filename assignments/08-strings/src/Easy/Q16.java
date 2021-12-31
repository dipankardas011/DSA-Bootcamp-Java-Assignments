package Easy;

public class Q16 {
    public boolean isPalindrome(String s) {
        // only compare letters and numbers and convert uppercase eot lowercase
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch))
                str.append(ch);
        }
        // System.out.println(str);
        // return false;
        s = str.toString();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {

            if (s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q16 ob = new Q16();
        System.out.println(ob.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
