import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Q18 {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int cur = K;

        List<Integer> ans = new ArrayList();

        int i = A.length;

        while (--i >= 0 || cur > 0) {
           // System.out.println("curr: "+cur);
           if (i >= 0)
               cur += A[i];

           ans.add(cur % 10);

           cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1,2,0,0};
        int k = 34;
        List<Integer> res = addToArrayForm(num,k);
        System.out.println(res.toString());
    }
}
