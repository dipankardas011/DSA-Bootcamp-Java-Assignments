package Medium;

import java.util.ArrayList;

public class Q9 {

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 || num2.length() == 1) {
            if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
                return "0";
        }
        if (num2.length() > num1.length())
            return multiply(num2, num1);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        num2 = (new StringBuilder(num2)).reverse().toString();
        // so num2 is smallest
        ArrayList<Integer> temp;
        int multiShift = 0;
        while (!num2.isEmpty()) {
            int multiplier = num2.charAt(0) - '0';
            int carry = 0;
            int iter = num1.length()-1;
            temp = new ArrayList<>();
            if (multiShift > 0) {
                int xyz = multiShift;
                while (xyz-- > 0) {
                    temp.add(0);
                }
            }
            multiShift ++;
            while (iter>=0) {

                int mD = multiplier * (num1.charAt(iter)-'0') + carry;
                carry = mD/10;
                if (mD <= 9) {
                    temp.add(mD);
                } else {
                    temp.add(mD%10);
                }
                // temp is in reverse format
                iter--;
            }
            if (carry > 0)
                temp.add(carry);

            res = additionOfRes(temp, res);

            num2 = num2.substring(1);
        }
        // res is also in reverse format

        StringBuilder Res = new StringBuilder();
        for (int i = res.size()-1; i >= 0 ; i--) {
            Res.append(""+res.get(i));
        }
        return Res.toString();
    }

    private ArrayList<Integer> additionOfRes(ArrayList<Integer> temp, ArrayList<Integer> res) {

        ArrayList<Integer> Add = new ArrayList<>();

        int carry = 0;
        int iterT = 0, iterR = 0;
        while (iterR < res.size() && iterT < temp.size()) {


            int sum = temp.get(iterT) + res.get(iterR) + carry;
//            System.out.println(temp.get(iterT) +" + "+ res.get(iterR) +" + "+ carry + " = "+sum);
            carry = sum/10;
            sum %= 10;
            Add.add(sum);

            iterR++;
            iterT++;
        }

        while (iterR < res.size()) {
            int sum = res.get(iterR) + carry;
            carry = sum/10;
            sum %= 10;
            Add.add(sum);
            iterR++;
        }

        while (iterT < temp.size()) {
            int sum = temp.get(iterT) + carry;
            carry = sum/10;
            sum %= 10;
            Add.add(sum);
            iterT++;
        }
        if (carry > 0)
            Add.add(carry);

        return Add;
    }

    public static void main(String[] args) {
        Q9 o = new Q9();
        System.out.println(o.multiply("236","22453"));
        System.out.println(o.multiply("3423","23425345345435"));
        System.out.println(o.multiply("4533","23423"));
        System.out.println(o.multiply("0","22453"));
        System.out.println(o.multiply("11","1"));
    }
}