package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q20 {

    private void
    utility(
            int[] arr, int target,
            List<List<Integer>> out,
            List<Integer> curr,
            int startIdx
    ) {
        if (target == 0) {
            out.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0)
            return;

        for (int i = startIdx; i < arr.length; i++) {

            if (i > startIdx && arr[i] == arr[i-1]) continue;   // remove duplicates

            curr.add(arr[i]);
            utility(arr, target-arr[i], out, curr, i+1);
            curr.remove(curr.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        utility(candidates, target, res, temp, 0);

        return res;
    }

    public static void main(String[] args) {
        Q20 o = new Q20();
        System.out.println(o.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}