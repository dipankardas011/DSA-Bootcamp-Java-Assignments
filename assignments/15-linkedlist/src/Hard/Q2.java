package Hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LFUCache {

    private int CAP;
    private int MIN = 0;
    private Map<Integer, Integer> K_V; // key -> value
    private Map<Integer, Integer> K_F; // key -> frequency
    private Map<Integer, LinkedHashMap<Integer, Integer>> LFU; // Frequency->{}

    public LFUCache(int capacity) {
        this.CAP = capacity;
        K_V=new HashMap<>();
        K_F=new HashMap<>();

        LFU = new HashMap<>();

        LFU.put(1, new LinkedHashMap<>());
    }

    public int get(int key) {
        if (CAP==0)
            return -1;
        if (!K_V.containsKey(key))
            return -1;
        int freq = K_F.get(key);
        K_F.put(key, freq+1);

        LFU.get(freq).remove(key); // removing that entry
        if (MIN == freq && LFU.get(freq).isEmpty()) // if its min and no more Maps in the Linklist then min++ and remove the entry for that freq
            MIN++;
        if (LFU.get(freq).isEmpty()) // if that entry of freq is no linklist of <K,V> then remove it
            LFU.remove(freq);

        int newFreq = freq+1;
        if (!LFU.containsKey(newFreq))
            LFU.put(newFreq, new LinkedHashMap<>());
        LFU.get(newFreq).put(key, K_V.get(key));
        return K_V.get(key);
    }

    public void put(int key, int value) {
        if (CAP == 0)
            return;
        if (!K_V.containsKey(key)) {
            // its no present

            if (K_V.size() == CAP) {
                int ele = LFU.get(MIN).keySet().iterator().next(); // the first element front of the LL ig
                LFU.get(MIN).remove(ele);

                K_V.remove(ele);
                K_F.remove(ele);
            }

            K_V.put(key, value);

            K_F.put(key, 1);
            if (!LFU.containsKey(1))
                LFU.put(1, new LinkedHashMap<>());
            LFU.get(1).put(key,value);
            MIN = 1;
        } else {
            // its present
            // update
            int freq = K_F.get(key);
            K_F.put(key, freq+1);
            K_V.put(key,value);

            LFU.get(freq).remove(key); // removing that entry
            if (MIN == freq && LFU.get(freq).isEmpty()) // if its min and no more Maps in the Linklist then min++ and remove the entry for that freq
                MIN++;
            if (LFU.get(freq).isEmpty()) // if that entry of freq is no linklist of <K,V> then remove it
                LFU.remove(freq);

            if (!LFU.containsKey(freq+1))
                LFU.put(freq+1, new LinkedHashMap<>());
            LFU.get(freq+1).put(key,value);
        }
    }
}

public class Q2 {
}
