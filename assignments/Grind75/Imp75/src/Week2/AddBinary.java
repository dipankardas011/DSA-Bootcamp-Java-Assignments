package Week2;

public class AddBinary {

    static class ReturnSum {
        Character sum;
        Character carry;

        public ReturnSum(Character sum, Character carry) {
            this.sum = sum;
            this.carry = carry;
        }
    }

    private ReturnSum addBit(Character op1, Character op2) {
        if ((op1 == '1' && op2 == '0') || (op1 == '0' && op2 == '1')) {
            // sum bit as 1 carry bit as 0
            return new ReturnSum('1', '0');
        } else if (op1 == '1' && op2 == '1') {
            // sum = 0 & carry =1
            return new ReturnSum('0', '1');
        } else {
            // sum = 0 & carry as 0
            return new ReturnSum('0', '0');
        }
    }

    private ReturnSum add3Bits(Character op1, Character op2, Character carry) {
        ReturnSum operation1 = addBit(op1, op2);
        ReturnSum operation2 = addBit(operation1.sum, carry);
//        addBit(operation1.carry, operation2.carry);
        Character resCarry = addBit(operation1.carry, operation2.carry).sum;
        Character resSum = operation2.sum;
        return new ReturnSum(resSum, resCarry);
    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b,a);
        }
        Character carry = '0';
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        StringBuilder res = new StringBuilder();

        while (aIdx >= 0 && bIdx >= 0) {
            ReturnSum find = add3Bits(a.charAt(aIdx), b.charAt(bIdx), carry);
            carry = find.carry;
            res.append(find.sum);
            aIdx--;
            bIdx--;
        }

        while (aIdx >= 0) {
            ReturnSum find = addBit(a.charAt(aIdx), carry);
            carry = find.carry;
            res.append(find.sum);
            aIdx--;
        }

        while (bIdx >= 0) {
            ReturnSum find = addBit(b.charAt(bIdx), carry);
            carry = find.carry;
            res.append(find.sum);
            bIdx--;
        }

        if (carry == '1')
            res.append(carry);
        return res.reverse().toString();
    }

    public String addBinaryBetter(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1","0"));
        System.out.println(new AddBinary().addBinary("0","0"));
        System.out.println(new AddBinary().addBinary("0","1"));
        System.out.println(new AddBinary().addBinary("1","1"));
        System.out.println(new AddBinary().addBinary("11","1"));
        System.out.println(new AddBinary().addBinary("1","11"));
        System.out.println(new AddBinary().addBinary("1010","1011"));
    }
}
