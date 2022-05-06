import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     * n = 9
     * 10, 20, 20, 10, 10, 30, 50, 10, 20
     * 3 --- Ans
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        HashMap<Integer, Integer> xyz = new HashMap<>();
        int count = 0;
        
        for (Integer x : ar) {
            if (xyz.containsKey(x)) {
                xyz.put(x, xyz.get(x) + 1);
            } else {
                xyz.put(x, 1);
            }
        }
        
        for (Object val : xyz.values()) {
            Integer dd = (Integer)val;
            count += (dd / 2);
        }
        
        return count;
    }

}

public class salesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

