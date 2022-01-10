package Hard;

public class Q1 {
    public boolean isNumber(String s) {

        boolean isDigit = false;
        boolean isDot = false;
        boolean isDigitAfterE = true;
        boolean isEe = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                isDigit = true;
                isDigitAfterE = true;
            }

            else if (ch == '.') {
                if (isDot || isEe)
                    return false;
                isDot = true;
            }

            else if (ch == 'e' || ch == 'E') {
                if (!isDigit || isEe)
                    return false;
                isEe = true;
                isDigitAfterE = false;
            }

            else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1)!='E')
                    return false;
            }

            else {
                return false;
            }
        }
        return isDigit && isDigitAfterE;
    }

    public static void main(String[] args) {
        Q1 o = new Q1();
        boolean[] testing = new boolean[]{
                true,
                true,
                false,
                true,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                true,
                true,
                false
        };
        System.out.println(o.isNumber("+91") == testing[0] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("-91") == testing[1] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("+") == testing[2] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("9") == testing[3] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("e") == testing[4] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("+35.0e45") == testing[5] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("+e") == testing[6] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("abcd") == testing[7] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("1a") == testing[8] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("1e") == testing[9] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("--6") == testing[10] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("++342edsdfw") == testing[11] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("-90E-10") == testing[12] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("324.234e4532") == testing[13] ? "CORRECT" : "WRONG");
        System.out.println(o.isNumber("91.45er") == testing[14] ? "CORRECT" : "WRONG");
    }
}
