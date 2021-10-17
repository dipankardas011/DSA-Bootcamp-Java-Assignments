import java.util.ArrayList;
import java.util.List;

public class MediumClass {
}

class Q1 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int minc = 0;
        int minr = 0;
        int maxr = matrix.length;
        int maxc = matrix[0].length;

        int maxCount = (maxr) * (maxc) ;

        int count = 0;

        while (count < maxCount) {
            // top elements
            for (int top = minc; top <maxc && count < maxCount; top++) {
                ans.add(matrix[minr][top]);
                count++;
            }
            // right elements
            for (int right = minr + 1; right < maxr && count < maxCount; right++) {
                ans.add(matrix[right][maxc-1]);
                count++;
            }

            // bottom elements
            for (int bottom = maxc - 2; bottom >= minc && count < maxCount; bottom--) {
                ans.add(matrix[maxr-1][bottom]);
                count++;
            }

            // left elements
            for (int left = maxr - 2; left > minr && count < maxCount; left--) {
                ans.add(matrix[left][minc]);
                count++;
            }
            minr++;
            minc++;
            maxc--;
            maxr--;
        }


        return ans;
    }

}
