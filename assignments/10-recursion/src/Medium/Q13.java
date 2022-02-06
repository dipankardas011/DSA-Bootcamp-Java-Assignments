package Medium;

public class Q13 {

    public int numSquares(int n) {

        int[] records = new int[n+1];

        for (int i = 0; i <= n; i++) {
            records[i] = i;

            for (int j = 1; j*j <= i; j++)
                records[i] = Math.min(records[i-j*j] + 1, records[i]);
        }

        return records[n];
    }

    public static void main(String[] args) {
        System.out.println(new Q13().numSquares(13));
    }
}