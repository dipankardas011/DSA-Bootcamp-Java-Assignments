package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDist = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minDist)
                minDist = diff;
        }
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i + 1] - arr[i] == minDist)
                res.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return res;
    }

    public static void main(String[] args) {
        Q18 o = new Q18();
        System.out.println(o.minimumAbsDifference(new int[]{4,2,1,3}));
    }
}
