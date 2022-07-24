package Medium;

import java.util.*;

public class Q16 {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int I = N-1;
        int J = 0;
        int rotateInc = +1;
        int[] arr = new int[N*N];
        for (int i = 0; i < N * N; i++) {
            arr[i] = board[I][J];

            if (rotateInc == 1 && J == N-1) {
                rotateInc = -1;
                I--;
            } else if (rotateInc == -1 && J == 0) {
                rotateInc = 1;
                I--;
            } else {
                J += rotateInc;
            }
        }

        int res = 0;

        boolean[] isVisited = new boolean[N*N];
        Queue<Integer> que = new LinkedList<>();

        int start = arr[0] > -1 ? arr[0]-1 : 0;
        isVisited[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int curr = que.poll();
                if (curr == N*N-1)
                    return res;
                for (int i = curr+1; i <= Math.min(N*N-1, curr+6); i++) {
                    int target = arr[i] > -1 ? arr[i] - 1 : i;
                    if (!isVisited[target]) {
                        que.add(target);
                        isVisited[target]=true;
                    }
                }
            }
            res++;
        }


        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        System.out.println(new Q16().snakesAndLadders(arr));
    }
}
