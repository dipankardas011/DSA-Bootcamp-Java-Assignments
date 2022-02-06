package Easy;

public class Q10 {
    public boolean isPrimeRec(int num, int i) {
        if (i == 1) {
            return isPrimeRec(num, i+1);
        }
        if (i*i <= num) {
            if (num % i == 0) {
                return false;
            } else {
                return isPrimeRec(num, i+1);
            }
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Q10 o = new Q10();
        System.out.println(o.isPrimeRec(131, 1));
    }
}
