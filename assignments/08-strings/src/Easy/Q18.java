package Easy;

public class Q18 {

    static public String longestCommonPrefix(String[] strs) {
        // if the substring are equal
        int len = strs.length;
        String ans = "";
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        int minlenOfComp = strs[0].length();
        for (String string : strs) {
            if (string.length() < minlenOfComp) {
                minlenOfComp = string.length();
            }
        }

        for (int cmp = 1; cmp <= minlenOfComp; cmp++) {
            String cppy = strs[0].substring(0, cmp);
            int flag = 0;
            // System.out.println("substring: " + cppy);
            for (int i = 1; i < len; i++) {
                String cc = strs[i].substring(0, cmp);
                // System.out.println("\tSUbstring to compare: " + strs[1].substring(0, cmp));
                if (cppy.equals(cc)) {
                    continue;
                } else {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            } else {
                ans = cppy;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] arr1 = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(arr1));

        String[] arr2 = { "ab", "a" };
        System.out.println(longestCommonPrefix(arr2));

    }
}
