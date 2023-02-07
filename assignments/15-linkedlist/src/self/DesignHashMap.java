package self;

import java.util.Arrays;

class MyHashMap {

    int[] map;

    public MyHashMap()
    {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }

    public int get(int key)
    {
        return map[key];
    }

    public void put(int key, int value)
    {
        map[key] = value;
    }

    public void remove(int key)
    {
        map[key] = -1;
    }
}
public class DesignHashMap {
}
