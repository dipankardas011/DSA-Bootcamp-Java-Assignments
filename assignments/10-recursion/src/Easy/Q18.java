package Easy;


public class Q18 {

    public String removeConsecutiveDuplicates(String input) {
        if(input.length()<=1)
            return input;
        if(input.charAt(0)==input.charAt(1))
            return removeConsecutiveDuplicates(input.substring(1));
        else
            return input.charAt(0) + removeConsecutiveDuplicates(input.substring(1));
    }

    public static void main(String[] args) {
        Q18 o = new Q18();
        String re = o.removeConsecutiveDuplicates("aaaabbbbc");
        System.out.println(re);
    }
}
