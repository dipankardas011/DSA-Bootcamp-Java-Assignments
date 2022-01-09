package Hard;

public class Q2 {
    public boolean isMatch(String s, String p) {
        boolean T[][] = new boolean[s.length()+1][p.length()+1];

        T[0][0]=true;
        for (int i = 1; i < T[0].length; i++) {
            if (p.charAt(i-1) == '*')
                T[0][i] = T[0][i-2];
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {

                if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1))
                    T[i][j] = T[i-1][j-1];

                else if (p.charAt(j-1) == '*') {
                    T[i][j] = T[i][j-2];
                    if (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1))
                        T[i][j] = T[i][j] | T[i-1][j];
                }
                else
                    T[i][j] = false;
            }
        }

        return T[s.length()][p.length()];
    }
    /** @see https://www.youtube.com/watch?v=l3hda49XcDE&list=PLrmLmBdmIlpuE5GEMDXWf0PWbBD9Ga1lO
      */
    public static void main(String[] args) {
        System.out.println(new Q2().isMatch("aa","a*"));
    }
}
