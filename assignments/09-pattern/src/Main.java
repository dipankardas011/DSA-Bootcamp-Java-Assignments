import java.io.CharConversionException;

class Q1{
    void printPattern(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

class Q2{
    void printPattern(int n){
        int col=0;
        for (int i = 0; i < 2*n; i++) {
            col = (n-1 <= i) ? col-1 : col+1;
            for(int j=0; j<col;j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}

class Q8{
    void printPattern(int n){
        for (int i=1; i<n; i++){
            for(int sp = 0; sp < n-i; sp++)
                System.out.print(" ");

            for(int j=1;j<2*i;j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

class Q13{
    void printPattern(int n){
        for (int i=1; i<=n; i++){
            for(int sp = 0; sp < n-i; sp++)
                System.out.print(" ");

            for(int j=1;j<2*i;j++)
                if(j==1 || j+1 ==2*i || i==n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }
    }
}


class Q16{
    void printPattern(int n){
        for (int line = 1; line <= n; line++) {
            for(int sp = 0; sp < n-line; sp++)
                System.out.print(" ");

            int C = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(C+" ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }
}

class Q18{
    void printPattern(int n){
        int col=0;
        int spcol = n+1;
        for (int i=1; i<2*n; i++){

            col = (i > n) ? col-1 : col+1;
            spcol = (n-i <0) ? spcol+1 : spcol-1;

            for(int sp = 0; sp < spcol; sp++)
                System.out.print("*");

            for(int j=1;j<2*col;j++)
                System.out.print(" ");

            for(int sp = 0; sp < spcol; sp++)
                System.out.print("*");


            System.out.println();
        }
    }

    void printPatternB(int n){
        int col=0;
        for (int i=1; i<=n; i++){

            col = (i == n) ? col-1 : col+1;

            for(int sp = 0; sp < n-i; sp++)
                System.out.print("*");

            for(int j=1;j<2*i;j++)
                System.out.print(" ");
            for(int sp = 0; sp < n-i; sp++)
                System.out.print("*");
            System.out.println();
        }
    }
}

class Q31{
    void printPattern(int n) {
        n--;
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row, n - col))+1;
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}

class Q33 {
    void printPattern(int n){
        char ch = 'a';
        int no=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if((no&1) == 1){
                    // odd
                    System.out.print(ch + " ");
                } else {
                    System.out.print(Character.toUpperCase(ch) + " ");
                }
                ch++;
                no++;
            }

            System.out.println();
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        q1.printPattern(5);

        Q2 q2 = new Q2();
        q2.printPattern(5);

        Q8 q8 = new Q8();
        q8.printPattern(5);

        Q13 q13 = new Q13();
        q13.printPattern(5);

        Q16 q16 = new Q16();
        q16.printPattern(5);

        Q18 q18 = new Q18();
        q18.printPattern(5);

        Q33 q33 = new Q33();
        q33.printPattern(5);

        Q31 q31 = new Q31();
        q31.printPattern(4);
    }
}
