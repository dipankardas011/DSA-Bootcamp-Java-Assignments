package Easy;

import java.util.Scanner;

public class Q6 {
    public int fun(int a, int b, int c, int n) {
        n -= 3;
        int t = 0;
        while (n-- > 0) {
            t = a + b + c;
            a=b;
            b=c;
            c=t;
        }
        return t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int n = in.nextInt();

            System.out.println(new Q6().fun(a, b, c, n));
        }
        in.close();
    }
}
