package Easy;

public class Q3 {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        int i=0;
        for (; i<command.length() - 1; i++) {
            if (command.charAt(i) == 'G'){
                ans.append('G');
            }
            else if (command.charAt(i) == '('){
                if (command.charAt(i+1)==')')
                    ans.append('o');
                else{
                    i+=2;
                    ans.append("al");
                }
            }
        }
         if (i==command.length()-1 && command.charAt(i)=='G')
             ans.append(command.charAt(i));
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q3().interpret("G()(al)"));
        System.out.println(new Q3().interpret("G()()()()(al)"));
        System.out.println(new Q3().interpret("(al)G(al)()()G"));
    }
}
