package Easy;

public class Q3 {
    public char first(String str, int i) {
        if (str.length() == i) {
            return '!';
        }
        if (Character.isUpperCase(str.charAt(i)))
            return str.charAt(i);


        return first(str,i+1);

    }

    public static void main(String[] args) {
        Q3 o = new Q3();

        System.out.println(o.first("geeksfForGeeks", 0));
        System.out.println(o.first("geeksforseeks", 0));
    }
}
