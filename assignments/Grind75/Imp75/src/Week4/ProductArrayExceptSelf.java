package Week4;

import java.util.Arrays;

public class ProductArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
      int N = nums.length;
      
      int[] left_prod = new int[N];
      int[] right_prod = new int[N];
      
      int[] output_arr = new int[N];
      left_prod[0] = 1;
      right_prod[N-1] = 1;

      for (int i=1;i<N;i++){
          left_prod[i] = nums[i-1]*left_prod[i-1];
      }

      for (int i=N-2;i>=0;i--){
          right_prod[i] = nums[i+1]*right_prod[i+1];
      }
      for (int i=0; i<N;i++) {
          output_arr[i] = left_prod[i]*right_prod[i];
      }
      return output_arr;
  }
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new ProductArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4})));
  }
}
