package Medium;

public class Q17 {

    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");

        int iter = 1;
        while (iter<n) {
            System.out.println(str);
            StringBuilder inv = new StringBuilder(str.toString());

            for (int i = 0; i < inv.length(); i++) {
                if (inv.charAt(i) == '0') {
                    inv.setCharAt(i,'1');
                } else {
                    inv.setCharAt(i,'0');
                }
            }

            str.append("1").append(inv.reverse().toString());
            iter++;
        }
        return str.charAt(k-1);
    }

    public static void main(String[] args) {
        Q17 o =new Q17();
        System.out.println(o.findKthBit(4,1));
    }
}
