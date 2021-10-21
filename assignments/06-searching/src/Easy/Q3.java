package Easy;

import java.util.Arrays;

public class Q3 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target)
                return new int[]{start+1, end+1};
            else if (sum > target)
                end--;
            else
                start++;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Q3 o = new Q3();
        System.out.println(Arrays.toString(o.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
