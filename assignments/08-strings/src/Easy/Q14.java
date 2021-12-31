package Easy;

public class Q14 {

    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if (j == needle.length())
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q14 obj = new Q14();
        String haystack = "";
        String needle = "";
        System.out.println("res: " + obj.strStr(haystack, needle));
        haystack = "hello";
        needle = "ll";
        System.out.println("res: " + obj.strStr(haystack, needle));

        haystack = "aaaaa";
        needle = "bba";
        System.out.println("res: " + obj.strStr(haystack, needle));
    }
}
