package Easy;

public class Q5 {
    public int arrangeCoins(int n) {
        // basically it is having
        // 1 + 2 + 3 + ... if then continuous sum becomes > n then break;
        long start = 1;
        long end = n;
        while(start<=end){
            //mid * mid will overflow, using long to avoid the overflow. Then casted it back to int while returning result.
            long mid = start+(end-start)/2;
            long currentSum = (mid*(mid+1))/2; // n(n+1) /2 Sum of N
            if(currentSum == n){
                return (int)mid;
            }else if(currentSum < n){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return (int)end;
    }

    public static void main(String[] args) {

    }
}
