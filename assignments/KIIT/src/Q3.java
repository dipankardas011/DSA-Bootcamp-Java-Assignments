public class Q3 {

    public int countPossibilities(char[] x, int idx) {
        if (idx == 1 || idx == 0)
            return 1;

        int count = 0;
        if (x[idx-1] >= '1' && x[idx-1] <= '9')
            count += countPossibilities(x, idx-1);

        if (x[idx-2] >= '1' || (x[idx-2] == '2' && x[idx-1] <= '6'))
            count += countPossibilities(x, idx-2);
        return count;
    }

    public static void main(String[] args) {
        int N = 1221;
        char[] ch = String.valueOf(N).toCharArray();
        System.out.println(new Q3().countPossibilities(ch, ch.length));
    }
}
