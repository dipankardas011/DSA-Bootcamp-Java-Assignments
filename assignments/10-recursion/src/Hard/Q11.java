package Hard;

public class Q11 {
    private int minCounter;

    private boolean isSafeBoundary(int r, int c, int M, int N) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }

    private void utility(int[][] mat, boolean[][] visited,
                         int countSteps, int r, int c) {
        if (c == mat[0].length - 1) {
            minCounter = Math.min(minCounter, countSteps);
            return;
        }
        if (minCounter < countSteps)
            return;

        if (!isSafeBoundary(r,c, mat.length, mat[0].length) || visited[r][c] || mat[r][c] == -1)
            return;

        visited[r][c] = true;

        // backtracing thing
        utility(mat, visited, countSteps+1, r, c-1);
        utility(mat, visited, countSteps+1, r, c+1);
        utility(mat, visited, countSteps+1, r-1, c);
        utility(mat, visited, countSteps+1, r+1, c);

        visited[r][c] = false;
    }

    public int findShortestPathUtil(int[][] mat) {
        minCounter = Integer.MAX_VALUE;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    if (isSafeBoundary(i,j-1,m,n))
                        mat[i][j-1] = -1;
                    if (isSafeBoundary(i,j+1,m,n))
                        mat[i][j+1] = -1;
                    if (isSafeBoundary(i-1,j,m,n))
                        mat[i-1][j] = -1;
                    if (isSafeBoundary(i+1,j,m,n))
                        mat[i+1][j] = -1;
                }
            }
        }
//        for (int[] r : mat)
//            System.out.println(Arrays.toString(r));

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            utility(mat, visited, 0, i, 0);
        }
        return minCounter;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
        System.out.println(new Q11().findShortestPathUtil(mat));
    }
}
