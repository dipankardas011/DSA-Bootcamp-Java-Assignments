package Medium;

public class Q8 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (x == 1)
            return x;
        long power = n;
        if (power < 0) {
            return calPower(1.0/x, -power);
        }
        return calPower(x, power);
    }

    private double calPower(double base, long power) {
        if (power == 0)
            return 1.0;
        // System.out.println("base: "+base+" power: "+power);
        if ((power & 1) == 1)
            return base*calPower(base*base,(power>>1));
        else
            return calPower(base*base, (power>>1));
    }

    public static void main(String[] args) {
        System.out.println(new Q8().myPow(2.00000,-2147483648));
        System.out.println(new Q8().myPow(2.00000,-2));
        System.out.println(new Q8().myPow(-1.00000,-2147483648));
        System.out.println(new Q8().myPow(2.00000,2147483647));
        System.out.println(new Q8().myPow(2.10,353));
    }
}
