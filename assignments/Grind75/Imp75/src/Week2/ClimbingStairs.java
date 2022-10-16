package Week2;

public class ClimbingStairs {
    public int climbStairs(int n) {

        if (n <= 2){
            return n;
        }

        int a = 1;
        int b = 2; // 2 possible answers when 2 away from goal (1,1) or (2)
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a+ b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
    }
}
