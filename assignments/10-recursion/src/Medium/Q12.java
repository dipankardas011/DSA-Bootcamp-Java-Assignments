package Medium;

import java.util.ArrayList;
import java.util.List;

public class Q12 {

    static class Ret {
        public int len;
        public List<Integer> listIndexes;

        public void display() {
            System.out.println(len);
            System.out.println(listIndexes);
        }
    };

    /**
     * TODO: this problem
     * @param list
     * @param tempList
     * @param nums
     * @param start
     */
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public int startIndx, endIndx;

//    private boolean utility(int d, int[] arr, int start, int sumT) {
//
//        if (sumT%d == 0) {
//            return true;
//        }
//
//        for (int i = start; i < arr.length; i++) {
//            sumT += arr[i];
//            startIndx = i;
//            if (utility(d,arr,i+1,sumT))
//                return true;
//            sumT -= arr[i];
//        }
//    }

//    public Ret divisibleSubset(int divisible, int[] list) {
//        Ret obj = new Ret();
//
//
//    }

    public static void main(String[] args) {
        Q12 obj = new Q12();
        int[] l = new int[]{4,6,10};
//        (obj.divisibleSubset(3,l)).display();
    }
}