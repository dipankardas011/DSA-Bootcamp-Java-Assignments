package Easy;

public class Q13 {
    public boolean isPowerOf4v1(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }

    public boolean isPowerOf4v2(int num) {
        if (num > 1) {
            while (num % 4 == 0)
                num /= 4;
            return num == 1;
        }
        return false;
    }
}
