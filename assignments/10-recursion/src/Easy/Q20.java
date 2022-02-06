package Easy;

import java.util.ArrayList;
import java.util.List;

public class Q20 {
    public static void main(String[] args) {
        char[] arr = "abc".toCharArray();
        List<List<Character>> ans = subset(arr);
        for (List<Character> list : ans) {
            System.out.println(list);
        }
    }

    static List<List<Character>> subset(char[] arr) {
        List<List<Character>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (Character num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Character> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}
