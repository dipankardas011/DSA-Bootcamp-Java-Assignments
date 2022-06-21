
public class LexicographicRank {
    public long getRank(String str) {
        if (str == null)
            return 0;
        long rank = 1;

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            long rankOfCh = 0;
            for (int j=i+1; j < str.length(); j++)
                if (str.charAt(j) < str.charAt(i))
                    rankOfCh++;

            /**
             * DCBA
             * here
             * D is in 3 rank from 0 based
             * remaining CBA are in 3! ways
             * 3! + 3! + 3!
             */
            rank += rankOfCh * factorial(str.length()-1-i);
        }
        return rank;
    }

    private long factorial(int i) {
        if (i == 0)
            return 1;
        return i*factorial(i-1);
    }

    public static void main(String[] args) {
        System.out.println(new LexicographicRank().getRank("DCBA"));
    }
}
