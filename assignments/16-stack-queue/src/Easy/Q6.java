package Easy;

import java.util.LinkedList;

public class Q6 {
}
class RecentCounter {
    LinkedList<Integer> list;
    public RecentCounter() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        list.addLast(t);
        while (list.getFirst() < t-3000) {
            list.removeFirst();
        }
        return list.size();
    }
}