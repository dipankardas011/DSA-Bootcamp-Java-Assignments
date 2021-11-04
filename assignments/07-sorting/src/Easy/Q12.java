package Easy;

public class Q12 {
    public int[] sortArrayByParityII(int[] nums) {
        int odd=1;
        int even=0;
        while(odd<nums.length && even<nums.length){
            if(nums[even]%2!=0){
                swap(nums, odd, even);
                odd=odd+2;
            }
            else{
                even=even+2;
            }
        }
        return nums;
    }
    static void swap(int[] nums, int first, int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}
