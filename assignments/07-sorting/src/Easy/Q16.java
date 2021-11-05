package Easy;

import java.util.Arrays;

public class Q16 {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];

        for (int i=0 ;i<heights.length; i++)
            expected[i] =  heights[i];
        Arrays.sort(expected);

        int count=0;
        for (int ind = 0; ind<expected.length; ind++)
            if (expected[ind] != heights[ind])
                count++;

        return count;
    }
}
