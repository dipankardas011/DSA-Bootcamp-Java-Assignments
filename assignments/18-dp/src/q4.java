package src;


public class q4 {
//    91 question code

    public int numDecodings(String s) {
        Integer[] mem=new Integer[s.length()];
        return util(s, 0, mem);
    }

    private int util(String str, int index, Integer[] mem) {
        int len = str.length();
        if (index == str.length())
            return 1;
        if (str.charAt(index) == '0')
            return 0;
        if (mem[index] != null)
            return mem[index];
        int res = util(str, index+1, mem);
        int val = index < len-1 ? Integer.parseInt(str.substring(index, index+2)) : 0;
        if (index < len-1 && val >= 10 && val <= 26)
            res += util(str, index+2, mem);
        mem[index] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new q4().numDecodings("12"));
        System.out.println(new q4().numDecodings("226"));
        System.out.println(new q4().numDecodings("06"));
        System.out.println(new q4().numDecodings("4698"));
    }
}
