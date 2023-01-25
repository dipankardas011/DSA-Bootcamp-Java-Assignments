import java.util.ArrayList;

public class findCenterStar {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        int[] countEdges = new int[n+1];
        for (int[] edge : edges) {
            countEdges[edge[0]]++;
            countEdges[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (countEdges[i] == edges.length)
                return i;
        }
        return -1;
    }
}
