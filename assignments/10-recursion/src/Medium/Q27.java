package Medium;

public class Q27 {
    int count = 0;

    private void utility(int n, boolean[] visited, int pos)
    {
        if (pos > n) {
            count++;
            return;
        }

        for (int iter = 1; iter <= n; iter++) {
            if (!visited[iter] && (iter%pos == 0 || pos%iter == 0)) {
                visited[iter]=true;
                utility(n,visited, pos+1);
                visited[iter]=false;
            }
        }

    }

    public int countArrangement(int n)
    {
        if (n == 0)
            return 0;

        utility(n, new boolean[n+1], 1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q27().countArrangement(3));
        System.out.println(new Q27().countArrangement(4));
    }
}