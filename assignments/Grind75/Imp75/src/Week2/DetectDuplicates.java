package Week2;

import java.util.HashMap;
import java.util.Map;

public class DetectDuplicates {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hsMap = new HashMap<>();

        for (Integer num : nums) {
            if (hsMap.containsKey(num))
                return true;
            else
                hsMap.put(num, 1);
        }
        return false;
    }
}
