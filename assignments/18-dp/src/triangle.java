package src;

import java.util.ArrayList;
import java.util.List;

public class triangle {
    private int execUtil(int row, int col, List<List<Integer>> triangle) {
        if (row == triangle.size()) {
            return 0;
        }
        int downLeft = triangle.get(row).get(col) + execUtil(row+1, col, triangle);
        int downRight = triangle.get(row).get(col) + execUtil(row+1, col+1, triangle);
        return Math.min(downLeft, downRight);
    }

    private int execUtilMem(int row, int col, List<List<Integer>> triangle, int[][] mem) {
        if (row == triangle.size()) {
            return 0;
        }
        if (mem[row][col] != -1)
            return mem[row][col];
        int downLeft = triangle.get(row).get(col) + execUtilMem(row+1, col, triangle, mem);
        int downRight = triangle.get(row).get(col) + execUtilMem(row+1, col+1, triangle, mem);
        mem[row][col] = Math.min(downLeft, downRight);
        return mem[row][col];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] mem = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mem[i][j] = -1;
            }
        }
        for (int i=0; i<triangle.get(size-1).size(); i++)
            mem[size-1][i] = triangle.get(size-1).get(i);

        for (int i = size-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int left = triangle.get(i).get(j) + mem[i+1][j];
                int right = triangle.get(i).get(j) + mem[i+1][j+1];
                mem[i][j] = Math.min(left, right);
            }
        }
        return mem[0][0];
    }
}
