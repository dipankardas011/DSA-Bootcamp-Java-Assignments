package Easy;

import java.util.ArrayList;

public class Q18 {
    public int subsetXORSum(int[] nums) {
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());

        for (int i = 0 ; i<nums.length; i++) {
            int len = subSets.size();

            for (int j = 0; j < len; j++) {
                ArrayList<Integer> x = new ArrayList<>(subSets.get(j));
                x.add(nums[i]);
                subSets.add(x);
            }
        }
        int sum = 0;
        for (ArrayList<Integer> arr : subSets) {
            int xor = 0;
            for (Integer nn : arr) {
                xor ^= nn;
            }
            sum += xor;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q18().subsetXORSum(new int[] {5,1,6}));
    }

}
