package Week1;

import java.util.Arrays;

public class FloodFill {
    private boolean isSafe(int i, int j, int r, int c) {
        return i >=0 && j >=0 && i < r && j < c;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if (color != image[sr][sc])
            getUtil(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    private void getUtil(int[][] img, int i, int j, int newC, int oldC) {
        if (!isSafe(i,j,img.length, img[0].length))
            return;
        
        if (img[i][j] != oldC)
            return;
        
        img[i][j] = newC;
        getUtil(img, i-1, j, newC, oldC);
        getUtil(img, i, j-1, newC, oldC);
        getUtil(img, i+1, j, newC, oldC);
        getUtil(img, i, j+1, newC, oldC);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int[][] newArr = new FloodFill().floodFill(arr, 1, 1, 2);
        for (int[] row : newArr)
            System.out.println(Arrays.toString(row));
        
    }
}
