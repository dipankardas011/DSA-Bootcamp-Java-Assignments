package Easy;

import java.util.List;

public class Q4 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;

        for (List<String> list : items) {
            if (ruleKey.compareTo("type") == 0){
                if(ruleValue.compareTo(list.get(0)) == 0)
                    ans++;
            }
            if (ruleKey.compareTo("color") == 0){
                if(ruleValue.compareTo(list.get(1)) == 0)
                    ans++;
            }
            if(ruleKey.compareTo("name") == 0){
                if(ruleValue.compareTo(list.get(2)) == 0)
                    ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
