package Medium;

public class Q13 {
    boolean isBoundary(int[][] mat, int i, int j) {
        return i == 0 || i == mat.length - 1 || j == 0 || j == mat[0].length - 1;
    }

    boolean isPeak(int[][] mat, int i, int j) {
        int ele = mat[i][j];
        // check if it is in boundary
        // if yes then
        int left = j-1;
        int up = i-1;
        int right = j+1;
        int down = i+1;
        if (isBoundary(mat, i,j)) {
            int count=0;
            if (right < mat[0].length && mat[i][right] < ele) // we can check
                count++;
            else if(right == mat[0].length && -1 < ele)
                count++;

            if (left >= 0 && mat[i][left] < ele) // we can check
                count++;
            else if(left == -1 && -1 < ele)
                count++;

            if (down < mat.length && mat[down][j] < ele) // we can check
                count++;
            else if(down == mat.length && -1 < ele)
                count++;

            if (up >= 0 && mat[up][j] < ele) // we can check
                count++;
            else if(up == -1 && -1 < ele)
                count++;

            return count == 4;

        } else {
            // normal check
            return mat[i][left] < ele &&
                    mat[i][right] < ele &&
                    mat[up][j] < ele &&
                    mat[down][j] < ele;
        }
    }

    public int findPeakElement(int[][] arr, int row) {
        // cant use the peak as the elements are repeated and unsorted and find the max element
//        int start = 0;
//        int end = arr[0].length-1;

//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (arr[row][mid] > arr[row][mid+1]) {
//                end = mid;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return start;
        int index = 0;
        int max = arr[row][index];
        for (int i = 1; i < arr[0].length; i++) {
            if (max < arr[row][i]){
                max = arr[row][i];
                index = i;
            }
        }
        return index;

    }

    public int[] findPeakGrid(int[][] mat) {
        int row = 0;
        while (row < mat.length) {
            int col = findPeakElement(mat, row);
            System.out.printf("[%d,%d]\n",row, col);
            if (isPeak(mat, row, col))
                return new int[]{row, col};
            row++;
        }
        return new int[]{-1,-1};

    }
}
