package Easy;

import java.util.Arrays;

public class Q11 {
    /**
     * All the colors of matrix are changes if src.color == neighboring colors
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Helper(image, visited,sr,sc,color, image[sr][sc]);
        return image;
    }

    boolean isValid(int row, int col, int nx, int ny) {
        return row >= 0 && row < nx && col >= 0 && col < ny;
    }

    public void Helper(int[][] image, boolean[][] visited, int i, int j, int newColor,int cc) {
        if (isValid(i,j,image.length, image[0].length) && !visited[i][j] && image[i][j] == cc) {
            visited[i][j] = true;
            image[i][j] = newColor;
            Helper(image, visited, i+1, j, newColor, cc);
            Helper(image, visited, i-1, j, newColor, cc);
            Helper(image, visited, i, j+1, newColor, cc);
            Helper(image, visited, i, j-1, newColor, cc);
        }
    }

    public static void display(int[][] a) {
        for (int[] row : a) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Q11 o = new Q11();
        int[][] arr= new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        display(arr);
        System.out.println();
        display(o.floodFill(arr, 1,1,2));
    }
}
