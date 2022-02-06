package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {

    private void utility(
            List<List<Integer>> list, List<Integer> temp,
            int[] num, int remain, int start
    ){
        if (remain<0)
            return;
        if (remain == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < num.length; i++) {
            temp.add(num[i]);
            utility(list,temp,num,remain-num[i],i);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] arr,
                                              int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(arr);
        utility(list,new ArrayList<>(),arr,target,0);

        return list;
    }

    public static void main(String[] args) {
        Q1 o = new Q1();
        System.out.println(o.combinationSum(new int[]{2,3,5},
                8));
    }
}
