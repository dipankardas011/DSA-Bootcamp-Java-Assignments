package Medium;

public class Q2 {
    public int minAddToMakeValid(String s) {
        int bracketC = 0;
        int res= 0;
        for (Character bracket : s.toCharArray()) {
            bracketC += bracket == '(' ? 1 : -1;
            if (bracketC == -1) {
                res++;
                bracketC++;
            }
        }
        return res+bracketC;
    }
}
