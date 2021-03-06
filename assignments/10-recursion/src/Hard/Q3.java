package Hard;

import java.util.ArrayList;

public class Q3 {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        k--;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = (k / fact);
            sb.append(num.remove(index));
            k -= index * fact;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q3().getPermutation(4, 3));
    }
}