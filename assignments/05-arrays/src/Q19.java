import java.sql.SQLOutput;

public class Q19 {
    public static int maximumPopulation(int[][] logs) {
        int N = 2050 - 1950; // 100
        int[] hash = new int[N + 1];

        for (int[] ith : logs) {
            hash[ith[0] - 1950]++; //birth
            hash[ith[1] - 1950]--; // death
        }
        for (int i = 1; i<hash.length; i++) {
            hash[i] += hash[i-1];
        }
//        //debug
//         for(int i = 0; i<hash.length; i++) {
//           System.out.println((i+1950) + " -> " + hash[i]);
//         }


        int maxYY = 1950; //default
        int maxPP = 0;
        for (int i = 0; i<hash.length; i++) {
            int pp = hash[i];
            if (pp > maxPP) {
                maxPP = pp;
                maxYY = i + 1950;
            }
        }
        return maxYY;
    }

    public static void main(String[] args) {
        int[][] yy = {{1950,1961},{1960,1971},{1970,1981}};
        System.out.println("Max Population: " + maximumPopulation(yy));
    }
}
