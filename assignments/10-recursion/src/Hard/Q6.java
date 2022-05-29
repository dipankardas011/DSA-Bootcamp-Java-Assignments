package Hard;

public class Q6 {

    private String[] lessThan20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = new String[] {
            "",
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return utility(num).trim();
    }
    private String utility(int num) {
        if (num == 0) {
            return "";
        }
        if (num >= 1_000_000_000)
            return utility(num/1_000_000_000).trim() + " Billion " +utility(num%1_000_000_000).trim();
        else if (num >= 1_000_000)
            return utility(num/1_000_000).trim() + " Million " +utility(num%1_000_000).trim();
        else if (num >= 1_000)
            return utility(num/1_000).trim() + " Thousand " +utility(num%1_000).trim();
        else if (num >= 100)
            return lessThan20[num/100] + " Hundred " +utility(num%100).trim();
        else if (num >= 20)
            return tens[num/10] + " " + lessThan20[num%10];
        else
            return lessThan20[num] + "";
    }

    public static void main(String[] args) {
        Q6 o = new Q6();
        System.out.println(o.numberToWords(20));
        System.out.println(o.numberToWords(220));
        System.out.println(o.numberToWords(24_520));
        System.out.println(o.numberToWords(202_342));
        System.out.println(o.numberToWords(2_023));
        System.out.println(o.numberToWords(0));
        System.out.println(o.numberToWords(50_868));
    }
}
