package Easy;

public class Q20 {

    // From the question, since there is no leading 0, so we can find if there is
    // any '01' within s. If there is, then it is false.

    public boolean checkOnesSegment(String s) {
        // int len = s.length();
        // for (int i = 0; i < len - 1; i++) {
        // if (s.charAt(i) == '0' && s.charAt(i + 1) == '1')
        // return false;
        // }
        // return true;

        return s.contains("01") ? false : true;
    }

    public static void main(String[] args) {
        Q20 obj = new Q20();
        System.out.println(obj.checkOnesSegment("1001"));
    }
}