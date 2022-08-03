package Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Q5 {

    class xYz {
        public int x;
        public int y;

        public xYz(int a, int b) {
            x=a;
            y=b;
        }
    }
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N)
    {
        int[] dx = new int[]{2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = new int[]{1, -1, 1, -1, 2, 2, -2, -2};

        int x1 = KnightPos[0], y1 = KnightPos[1];
        int x2 = TargetPos[0], y2 = TargetPos[1];
        int [][]a = new int[1001][1001];

        if(x1 == x2 && y1 == y2){
            return 0;
        }

        Queue<xYz> q = new ArrayDeque<>();

        q.add(new xYz(x1-1,y1-1));
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if((nx >= 0 && nx < N && ny >= 0 && ny < N) && a[nx][ny] == 0){
                    a[nx][ny] = a[x][y] + 1;
                    q.add(new xYz(nx, ny));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        return a[x2 - 1][y2 - 1];
    }
    public static void main(String[] args) {
        System.out.println(new Q5().minStepToReachTarget(new int[]{4,5}, new int[]{1,1}, 6));
    }
}
