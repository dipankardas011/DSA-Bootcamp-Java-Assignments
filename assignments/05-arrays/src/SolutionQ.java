import java.util.*;

class SolutionQ {

    public boolean isEqual (int[][] mat, int[][] target) {
        for (int i=0; i<mat.length; i++) {
            for(int j=0;j<mat.length; j++)
                if(mat[i][j] != target[i][j])
                    return false;
        }
        return true;
    }

    public void display(int[][] mat) {
        for(int[] k: mat)
            System.out.println(Arrays.toString(k));
    }

    public int isSame1s(int[][] mat) {
        int count=0;
        for (int[] row : mat) {
            for (int col : row)
                if (col == 1)
                    count++;
        }
        return count;
    }

    public boolean findRotation(int[][] mat, int[][] target) {

        if (isSame1s(mat) != isSame1s(target))
            return false;
        int count = 0;
        while (!isEqual(mat, target) && ++count < 5) {
            int[][] matN = new int[mat.length][mat.length];
            for (int col=0;col<mat.length;col++){
                for(int row=0;row<mat.length;row++) {
                    matN[col][row] = mat[row][col];
                }
            }
            for (int i = 0; i < mat.length; i++) {
                System.arraycopy(matN[i], 0, mat[i], 0, mat.length);
            }


            int l = 0, r = mat.length-1;
            while (l < r) {

                for(int row = 0; row<mat.length; row++)
                {
                    int t = mat[row][l];
                    mat[row][l] = mat[row][r];
                    mat[row][r] = t;
                }

                l++;
                r--;
            }
        }
        return count <= 4;
    }

    public static void main(String[] args) {
        SolutionQ obj = new SolutionQ();
       int[][] arr1 = {{0,1},{1,0}};
       // if it matches with the true or false it is correct
        ArrayList<Boolean> ans = new ArrayList<>(3);
        ans.add(true);
        ans.add(false);
        ans.add(true);
        // test cases
        System.out.println(((obj.findRotation(arr1,new int[][]{{1,0},{0,1}})) == ans.get(0)) ? "✔ Correct":"❌ Wrong");
       int[][] arr2 = {{0,1},{1,1}};
        System.out.println(((obj.findRotation(arr2,new int[][]{{1,0},{0,1}})) == ans.get(1)) ? "✔ Correct":"❌ Wrong");
       int[][] arr3 = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(((obj.findRotation(arr3,new int[][]{{1,1,1},{0,1,0},{0,0,0}})) == ans.get(2)) ? "✔ Correct":"❌ Wrong");
    }
}

class Q21 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{ map.get(comp), i };
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

class Q22 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int left = 0, right = n-1;
        int org = n;
        while (left < right) {

            ans[left] = -org;
            ans[right] = org;

            org--;
            left++;
            right--;
        }
        return ans;
    }
}

class Q23 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>(1);
        int ans = 0;
        for (int row = 0; row < matrix.length; row++) {
            int min = matrix[row][0];
            int indexCol=0;

            for (int col = 1; col < matrix[0].length; col++) {
                // minim of rows
                if (min > matrix[row][col]) {
                    indexCol = col;
                    min = matrix[row][col];
                }
            }
            // find the max of the row in that col
            int max = matrix[0][indexCol];
            for (int row11 = 1; row11 < matrix.length; row11++) {
                if (max < matrix[row11][indexCol])
                    max = matrix[row11][indexCol];
            }
            if (max == min) {
                res.add(min);
            }
        }
        return res;
    }
}

class Q24 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            sum += i;
            max = Math.max(max, sum);
            // if sum becomes less than 0 then reset it
            sum = sum < 0  ? 0 : sum;
        }
        return max;
    }
}

class Q25 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r*c != mat.length * mat[0].length)
            return mat;

        int[][] ans = new int[r][c];
        int r1=0,c1=0;

        for (int row = 0; row<mat.length; row++) {
            for (int col = 0; col<mat[0].length; col++) {
                if (c1 == c) {
                    c1 = 0;
                    r1++;
                }
                ans[r1][c1++] = mat[row][col];
            }
        }
        return ans;
    }
}