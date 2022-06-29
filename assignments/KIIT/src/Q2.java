public class Q2 {

    static int MAXSUM=Integer.MIN_VALUE;
    static int leftPointer, rightPointer;
    public int getMaximumSubArray(int[] arr) {
        for (int i:arr)
            MAXSUM += i;

        getMaxSum(arr, 0, arr.length-1);
        for (int i = leftPointer; i <= rightPointer; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return MAXSUM;
    }

    private void getMaxSum(int[] arr, int left, int right){
        if (left > right)
            return;
        int currSum=0;
        for (int i=left; i<=right;i++)
            currSum += arr[i];
        if (currSum > MAXSUM){
            MAXSUM = currSum;
            leftPointer=left;
            rightPointer=right;
        }
        getMaxSum(arr, left+1, right);
        getMaxSum(arr, left, right-1);
    }

    public static void main(String[] args) {
        System.out.println(new Q2().getMaximumSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
