package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q6 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            if (!hashSet.add(s.substring(i, i+10))) {
                res.add(s.substring(i, i+10));
            }
        }

        return new ArrayList<>(res);
    }
}
