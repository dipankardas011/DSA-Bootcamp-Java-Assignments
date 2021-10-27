package Medium;

public class Q12 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = 0;
        int cols = matrix[0].length-1;

        while (rows < matrix.length && cols >=0 ) {
            if (matrix[rows][cols] > target) {
                cols--;
            }
            else if (matrix[rows][cols] < target) {
                rows++;
            }else{
                return true;
            }
        }
        return false;
    }
}
