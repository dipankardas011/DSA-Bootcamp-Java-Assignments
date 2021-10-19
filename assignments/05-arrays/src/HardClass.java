import java.util.ArrayDeque;
import java.util.Deque;

class HardClass {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[][] arr={{1,3},{2,0},{5,10},{6,-10}};
        int k=4;
        // o/p == 1
        System.out.println(q1.findMaxValueOfEquation(arr,k));
    }
}
class Q1 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0 ; i < points.length; i++) {
            // pick the index at the front of deque and if the difference between current x
            // and x in peeked index is greater than k then we dont need the peeked value in deque
            // so remove it using poll
            while (!q.isEmpty() && points[i][0] - points[q.peek()][0] > k)
                q.poll();

            // now the difference of current point's x and x of the front index of deque will be <= k
            // so calculate ans
            /***
             * Return the
             * maximum value of the equation yi + yj + |xi - xj|
             * where |xi - xj| <= k and 1 <= i < j <= points.length.
             */
            if (!q.isEmpty())
                ans = Math.max(ans, points[i][0] + points[i][1] + points[q.peek()][1] - points[q.peek()][0]);

            // if the non checked values i.e. the difference of y - x of indexes at the end of deque is smaller
            // than current y - x then we don't need those values as we already have the greater value so
            // remove the indexes from end using pollLast()
            while (!q.isEmpty() && points[q.peekLast()][1] - points[q.peekLast()][0] < points[i][1] - points[i][0])
                q.pollLast();


            // add current index to the end of deque
            q.addLast(i);
        }
        return ans;
    }

    class q3 {
        public boolean isGoodArray(int[] nums) {

            int p = nums[0];
            for (int i=1; i<nums.length; i++) {
                p = gcd(nums[i], p);
            }
            // check if all possible cases gives 1 ass gcd
            return p == 1;
        }
        public int gcd( int a, int b ) {

            if (a == 0)
                return b;
            if (a>b)
                return gcd (b,a);
            return gcd (b%a,a);
        }
    }
}