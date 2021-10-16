/**
 * Easy Q23
 */


public class B01{
    
    static void factors(int n) {

        for(int i = 2; i < n; i++) {
            if(n % i == 0)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 24;
        factors(n);
    }
}