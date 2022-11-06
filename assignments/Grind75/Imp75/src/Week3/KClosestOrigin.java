package Week3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestOrigin {

    class Type {
        public int[] mat;
        float distance;
        public Type(int i, int j, float d) {
            mat = new int[2];
            mat[0] = i;
            mat[1] = j;
            distance = d;
        }
    }

    class ComparatorType implements Comparator<Type> {

        // Overriding compare()method of Comparator
        public int compare(Type s1, Type s2) {
            if (s1.distance > s2.distance)
                return 1;
            else if (s1.distance < s2.distance)
                return -1;
            return 0;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Type> que = new PriorityQueue<>(new ComparatorType());
        for (int[] point : points) {
            float d = (float) Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            que.add(new Type(point[0], point[1], d));
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Type temp = que.poll();
            res[i] = temp.mat;
        }
        return res;
    }
}
