package Easy;

public class Q13 {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();

        while(columnNumber>0){
            columnNumber--;
            str.append((char)('A'+columnNumber%26));
            columnNumber /= 26;
        }

        str.reverse();

        return str.toString();
    }

    public static void main(String[] args) {
        Q13 o = new Q13();
        System.out.println(o.convertToTitle(701));
    }
}
