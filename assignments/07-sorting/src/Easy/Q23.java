package Easy;

public class Q23 {
    public double average(int[] salary) {
        double min = 1000001.0;
        double max = 0.0;
        double sum = 0.0;
        for (int i : salary) {
            sum += i;
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        sum -= (max+min);
        return sum/(double)(salary.length - 2);
    }
}
