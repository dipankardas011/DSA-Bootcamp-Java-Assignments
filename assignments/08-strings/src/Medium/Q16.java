package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q16 {
    public int findMinDifference(List<String> timePoints) {
        // convert each time point to the minutes
        ArrayList<Integer> arr = new ArrayList<>();
        for (String time : timePoints) {
            int HH = Integer.parseInt(time.substring(0,2));
            int MM = Integer.parseInt(time.substring(3));
            int mins = HH*60 + MM;
            arr.add(mins);
        }
        int min = Integer.MAX_VALUE;
        Collections.sort(arr);

        for (int i=1; i<timePoints.size(); i++) {
            min = Math.min(min, arr.get(i) - arr.get(i-1));
        }
        int cornerLowestHighest = arr.get(0) + (1440 - arr.get(arr.size()-1));
        return Math.min(min, cornerLowestHighest);
    }

    public static void main(String[] args) {

    }
}
