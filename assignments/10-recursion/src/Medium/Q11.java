package Medium;

public class Q11 {
//https://www.hackerrank.com/challenges/the-power-sum/problem?isFullScreen=true
    private static int util(int target, int power, int number) {
        int subValue = target - (int)Math.pow(number,power);
        if (subValue == 0 )
            return 1;
        if (subValue < 0)
            return 0;

        return util(subValue, power, number+1) + util(target, power, number+1);
    }
    public static int powerSum(int target, int power) {
        return util(target,power,1);
    }

    public static void main(String[] args) {
        System.out.println(powerSum(100,3));
    }
}
