import java.util.Arrays;

/***
 * @example 1389. Create Target Array in the Given Order
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * Example 2:
 *
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 */

public class Q09 {
    public static void main(String[] args) {
        Solution ob = new Solution();
        int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
        System.out.println(Arrays.toString(ob.createTargetArray(nums, index)));
    }
}
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];

        for(int i=0;i<nums.length;i++)
            target[i] = -1;

        for (int i=0;i<nums.length; i++)
        {    // here we need to displace the elements to right
            if (target[index[i]] == -1)
                target[index[i]] = nums[i];
            else
            {
                // right shift elements before we insertt at that position
                int in = nums.length-1;
                while(target[in]==-1){
                    in--;
                }
//                System.out.println(in);
                while(in >= index[i]){
                    target[in+1] = target[in];
                    in--;
                }
                target[index[i]] = nums[i];
            }
//            System.out.println(Arrays.toString(target));
        }

        return target;
    }
}