package Easy;

/**
 * But there is a check if a given number is not a perfect square, you just have to apply the following 2 steps,
 *
 * 1.A Perfect Square always ends with one of these numbers ( 0, 1, 4, 5, 6, 9). If it doesn’t, given number is not a Perfect Square.
 *
 * 2. Now if it satisfies above condition then check the digital summation of a number. In digital summation you keep on adding all the digits of a number till you get a single number.
 * A Perfect Square always have digital summation of one of these numbers ( 1, 4, 7, 9), if it doesn’t it’s not a Perfect Square.
 *
 * Example :
 *
 * 1.263 : Ends with 3, not a perfect square.
 *
 * 2. 371 : Ends with 1, so it might be a perfect square. Go to step 2.
 * Digital Summation : 3+7+1 = 11 = 1+1 = 2. So, not a Perfect Square.
 *
 * Problem comes when you have number like 361 and 391.
 *
 * 361 : Satisfies condition 1 (Ends with 1),
 * Digital Summation : 3+6+1 = 10 = 1+0 = 1. Satisfies condition 2.
 *
 * 391 : Satisfies condition 1 (Ends with 1)
 * Digital Summation : 3+9+1 = 13 = 1+3 = 4. Satisfies condition 2.
 *
 * But, we know 361 is a perfect square(19*19) and 391 is not, so this method has a loophole here.
 **/

public class Q4 {
    boolean isPerfectSquare(int num) {
        if(num ==1)
            return true;
        else if(num==0)
            return false;
        int low = 1,high = num/2;
        long y ;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            y = (long) mid *mid;
            if(y == num)
                return true;
            else if(y > num)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        Q4 o = new Q4();
        System.out.println(o.isPerfectSquare(16));
    }
}
