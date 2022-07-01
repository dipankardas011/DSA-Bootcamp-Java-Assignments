package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {
// this is O(1) approach
    Deque<Integer> dq1, dq2;
    public FrontMiddleBackQueue() {
        dq1 = new ArrayDeque<>();
        dq2 = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        dq1.addFirst(val);
    }

    public void pushBack(int val) {
        dq2.addLast(val);
    }

    public void pushMiddle(int val) {
        while(dq1.size() + 1 < dq2.size())
            dq1.addLast(dq2.removeFirst());
        while(dq1.size() > dq2.size())
            dq2.addFirst(dq1.removeLast());
        dq1.addLast(val);
    }

    public int popFront() {
        if(!dq1.isEmpty())
            return dq1.removeFirst();
        if(!dq2.isEmpty())
            return dq2.removeFirst();
        return -1;
    }

    public int popMiddle() {
        if(dq1.isEmpty() && dq2.isEmpty())
            return -1;
        while(dq1.size() < dq2.size())
            dq1.addLast(dq2.removeFirst());
        while(dq1.size() > dq2.size() + 1)
            dq2.addFirst(dq1.removeLast());
        return !dq1.isEmpty() ? dq1.removeLast() : dq2.removeFirst();
    }

    public int popBack() {
        if(!dq2.isEmpty())
            return dq2.removeLast();
        if(!dq1.isEmpty())
            return dq1.removeLast();
        return -1;
    }
}


public class Q8 {
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());    // return 4 -> [2]
        System.out.println(q.popBack());      // return 2 -> []
        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)
    }
}
