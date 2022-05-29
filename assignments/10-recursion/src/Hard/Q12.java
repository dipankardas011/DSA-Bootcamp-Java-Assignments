package Hard;

public class Q12 {

    private int minCount;

    public int minSteps(int D){
        int sum = 0;
        int i = 1;
        while (true) {
            sum += i;
            if (sum == D)
                return i;
            if (sum > D && ((sum-D)&1) == 0)
                return i;
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q12().minSteps(10));
        System.out.println(new Q12().minSteps(2));
    }
}
