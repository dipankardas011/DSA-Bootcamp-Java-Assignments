package Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Q31 {
    public void getAllPaths() {
        int mat[][] = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        // find longest path with source (0, 0) and
        // destination (1, 7)
        findLongestPath(mat, 0, 0, 1, 7);
        System.out.println("Ans: "+maxCount);
        for (ArrayList<Integer> ss : arr) {
            System.out.println(ss);
        }

    }

    private ArrayList<ArrayList<Integer>> arr;
    private int maxCount;

    private void pathFinder(int[][] mat,
                           int r, int c,
                           int destR, int destC)
    {
        if (!isValid(r,c,mat.length, mat[0].length) || mat[r][c] != 1) {
            return;
        }

        if (r == destR && c == destC) {
//            for (int[] rr : mat) {
//                for (int x : rr) {
//                    System.out.print(x+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            int count=0;
            for (int[] rr : mat) {
                for (int x : rr) {
                    if (x == 9)
                        count++;
                }
            }
//            System.out.println(count);
            if (count > maxCount) {
                maxCount = count;
                if (arr == null)
                    arr = new ArrayList<>();
                else
                    arr.clear();
                for (int[] ints : mat) {
                    ArrayList<Integer> ll = new ArrayList<>();
                    for (int ii : ints) {
                        ll.add(ii);
                    }
                    arr.add(ll);
                }
            }
        }

        mat[r][c] = 9;

        pathFinder(mat, r-1, c, destR, destC);
        pathFinder(mat, r+1, c, destR, destC);
        pathFinder(mat, r, c-1, destR, destC);
        pathFinder(mat, r, c+1, destR, destC);

        mat[r][c] = 1;
    }

    private boolean isValid(int r, int c, int lR, int lC) {
        return r >= 0 && r < lR && c >= 0 && c < lC;
    }

    private void findLongestPath(int[][] mat, int sR, int sC, int dR, int dC) {
        maxCount = Integer.MIN_VALUE;
        pathFinder(mat, sR, sC, dR, dC);
    }

    public static void main(String[] args) {
        new Q31().getAllPaths();
    }
}