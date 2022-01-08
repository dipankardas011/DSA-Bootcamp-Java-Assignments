package Medium;

import java.util.Arrays;

public class Q7 {
    private boolean isSubSeq(String s, String p) {
        if (s.equals(p))
            return true;

        int j = 0;

        for (int i = 0; i< p.length() && j < s.length(); i++)
            if (s.charAt(j) == p.charAt(i))
                j++;

        return j == s.length();
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int[] map = new int[s.length()];

        Arrays.fill(map, removable.length);
        for (int i =0 ; i < removable.length; i++)
            map[removable[i]]=i;
        int l = 0, r = s.length();

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int j = 0;
            for (int i = 0; i < s.length() && j < p.length(); i++)
                if (map[i] >= mid && s.charAt(i) == p.charAt(j))
                    j++;

            if (j == p.length())
                l = mid;    // as the guess was correct to get the higher guess move to right as traversing to the removable[] length
            else
                r = mid-1;  // guess was to high i.e. k more than it can be subSeq .
        }
        return l;
    }
    public static void main(String[] args) {
        Q7 ob = new Q7();

        System.out.println(ob.maximumRemovals("abcab","abc", new int[]{0,1,2,3,4}));
        System.out.println(ob.maximumRemovals("abcbddddd","abcd", new int[]{3,2,1,4,5,6}));
        System.out.println(ob.maximumRemovals("abcacb","ab", new int[]{3,1,0}));

    }
}
