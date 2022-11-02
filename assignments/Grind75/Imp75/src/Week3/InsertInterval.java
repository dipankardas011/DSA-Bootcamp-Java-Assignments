package Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    /**
     * Magic Algo just hit and try
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        /**
         * (a,b) i
         * (c,d) newInterval
         * b < c || d < a no overlap
         */
        for(int[] i : intervals){
            if(newInterval == null || i[1] < newInterval[0]){
                result.add(i);
            }else if(i[0] > newInterval[1]){
                /**
                 * first add the new interval to the result then current interval
                 */
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            }else{
                newInterval[0] = Math.min(newInterval[0], i[0]);//get min
                newInterval[1] = Math.max(newInterval[1], i[1]);//get max
            }
        }

        if(newInterval != null)
            result.add(newInterval);

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
}
