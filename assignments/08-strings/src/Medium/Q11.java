package Medium;

public class Q11 {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        if (s.length() == 1) {
            return 1;
        }


        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return right-left + 1;
            }
            int x = s.charAt(left);
            while (left<right && s.charAt(left) == s.charAt(right))
                left++;

            if (left == right && x == s.charAt(right))
                return 0;

            while (right>left && x == s.charAt(right))
                right--;

        }
        return 1;
    }

    public static void main(String[] args) {
        Q11 o = new Q11();
        System.out.println(o.minimumLength("caddaadfddac"));
    }
}
