package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    private int removeDuplicates(int arr[], int n)
    {
        if (n == 0 || n == 1)
            return n;

        // To store index of next unique element
        int j = 0;

        // Doing same as done in Method 1
        // Just maintaining another updated index i.e. j
        for (int i = 0; i < n-1; i++)
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];

        arr[j++] = arr[n-1];

        return j;
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int numLength = removeDuplicates(nums, nums.length);
        List<List<Integer>> subSet = new ArrayList<>();

        subSet.add(new ArrayList<>());
        for (int i = 0; i < numLength; i++) {
            int size = subSet.size();
            for (int j = 0; j < size; j++) {
                List<Integer> xx = new ArrayList<>(subSet.get(j));
                xx.add(nums[i]);
                subSet.add(xx);
            }
        }


        return subSet;
    }

    public static void main(String[] args) {
        System.out.println(new Q1().subsets(new int[]{1,2,3}));
        System.out.println(new Q1().subsets(new int[]{0}));
    }
}
