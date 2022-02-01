package Medium;

public class Q18 {

    public boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }

    private int winner(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - winner(nums, s + 1, e, memo);
        int b = nums[e] - winner(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }

    public static void main(String[] args) {
        Q18 obj = new Q18();
        System.out.println(obj.PredictTheWinner(new int[]{1,5,2}));
        System.out.println(obj.PredictTheWinner(new int[]{1,5,233,7}));
    }
}