package Medium;

import java.util.ArrayList;
import java.util.List;

public class Q21 {

    private void
    utility(
            int[] arr, int target,
            List<List<Integer>> out,
            List<Integer> temp,
            int startIdx,
            int k
    ) {
        if (target == 0) {
            if (temp.size() == k)
                out.add(new ArrayList<>(temp));
            return;
        }

        if (temp.size() > k || target < 0)
            return;

        for (int i = startIdx; i < arr.length; i++) {
            temp.add(arr[i]);
            utility(arr, target-arr[i], out, temp, i+1, k);
            temp.remove(temp.size() - 1);
        }

    }

    /**
     * replaced the arr with the loop index as it is the same
     * @param len
     * @param target
     * @param out
     * @param temp
     * @param startIdx
     * @param k
     */
    private void
    utilityv2(
            int len, int target,
            List<List<Integer>> out,
            List<Integer> temp,
            int startIdx,
            int k
    ) {
        if (target == 0) {
            if (temp.size() == k)
                out.add(new ArrayList<>(temp));
            return;
        }

        if (temp.size() > k || target < 0)
            return;

        for (int i = startIdx; i <= len; i++) {
            temp.add(i);
            utilityv2(len, target-i, out, temp, i+1, k);
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
//        utility(arr, n, res, new ArrayList<>(), 0,k);
        utilityv2(9, n, res, new ArrayList<>(), 1,k);
        return res;
    }

    public static void main(String[] args) {
        Q21 o = new Q21();
        System.out.println(o.combinationSum3(3, 7).toString());
    }
}