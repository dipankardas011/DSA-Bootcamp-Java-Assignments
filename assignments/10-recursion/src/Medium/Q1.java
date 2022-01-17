package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=  new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(list, new ArrayList<>(), candidates, target, target);
        return list;
    }

    private void backTrack(List<List<Integer>> l, List<Integer> t, int[] cand, int remain, int target) {
        if (remain < 0)
            return;
        if (remain == 0 ){
            l.add(new ArrayList<>(t));
        }
        else {
            for (int j : cand) {
                t.add(j);
                backTrack(l, t, cand, target - j, j);
                t.remove(t.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q1 o = new Q1();
        System.out.println(o.combinationSum(new int[]{2,3,5}, 8));
    }
}
