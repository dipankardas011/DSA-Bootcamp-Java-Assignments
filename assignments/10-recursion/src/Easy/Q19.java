package Easy;

public class Q19 {
    private boolean isPalin(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public void allPermutation(String s, int i, int j) {
        if (i < s.length()) {
            if (j < s.length()) {
                String ss = s.substring(i,j+1);
                if (isPalin(ss))
                    System.out.println(ss);
                allPermutation(s,i,j+1);
            } else {
                allPermutation(s,i+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        Q19 o = new Q19();
        o.allPermutation("geeks", 0, 0);
    }
}
