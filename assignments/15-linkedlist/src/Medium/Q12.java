package Medium;


import java.util.HashMap;

class LRUCache {

    class LL {
        int key;
        int value;
        LL next;
        public LL(int k, int v) {
            key=k;
            value=v;
            next=null;
        }
    }
    HashMap<Integer, Integer> hsMap = null;
    private LL head, tail;
    private int size;
    private int CAP;

    public LRUCache(int capacity) {
        CAP = capacity;
        size = 0;
        head = null;
        tail = null;
        hsMap = new HashMap<>();
    }

    public int get(int key) {
        if (hsMap.get(key) != null) {
            int v = hsMap.get(key);
            deleteLL(key);
            insertKV(key, v);
            return v;
        }
        return -1;
    }
    public boolean Found(int key) {
        return hsMap.get(key) != null;
    }

    /**
     * Insert at back
     * @param k key
     * @param v value
     */
    private void insertKV(int k, int v) {
        if (head == null)
            head = tail = new LL(k, v);
        else {
            tail.next = new LL(k, v);
            tail = tail.next;
        }
        hsMap.put(k,v);
        size++;
    }

    private void deleteLL(int key) {
        hsMap.remove(key);
        if (head.key == key) {
            head = head.next;
            size--;
            return;
        }
        LL iter = head, prev = null;
        while (iter.next != null) {
            if (iter.key == key) {
                break;
            }
            prev = iter;
            iter = iter.next;
        }
        prev.next = iter.next;
        if (prev.next == null)
            tail = prev;// update tail
        size--;
    }

    public void put(int key, int value) {
        boolean isThere = Found(key);
        if (isThere) {
            // do something
            deleteLL(key);
            insertKV(key, value);
        } else {
            if (size + 1 <= CAP) {
                insertKV(key, value);
            } else {
                hsMap.remove(head.key);
                head = head.next;
                size--;
                insertKV(key, value);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class Q12 {
    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        System.out.print(lRUCache.get(2)+" ");
//        lRUCache.put(2,6);
//        System.out.print(lRUCache.get(1)+" ");
//        lRUCache.put(1,5);
//        lRUCache.put(1,2);
//
//        System.out.print(lRUCache.get(1)+" ");
//        System.out.print(lRUCache.get(2)+" ");
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
