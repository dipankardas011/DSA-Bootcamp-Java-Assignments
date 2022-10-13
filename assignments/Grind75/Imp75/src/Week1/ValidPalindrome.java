package Week1;

public class ValidPalindrome {
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
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }
}
