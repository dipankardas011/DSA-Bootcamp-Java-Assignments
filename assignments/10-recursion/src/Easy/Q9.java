package Easy;

public class Q9 {
    public int prodOf2Numbers(int a, int b) {
        // assuming that a < b
        // so a-- + ...
        if (b < a) {
            return prodOf2Numbers(b,a);
        }

        if (a == 0)
            return 0;

        return b+prodOf2Numbers(a-1,b);
    }

    public static void main(String[] args) {
        Q9 o = new Q9();
        System.out.println(o.prodOf2Numbers(100,5));
    }
}
