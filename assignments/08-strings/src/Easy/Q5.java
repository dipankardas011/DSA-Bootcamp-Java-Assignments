package Easy;

import java.util.Arrays;
import java.util.Comparator;

public class Q5 {

    private class Comparing implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String lastA = ""+a.charAt(a.length()-1);
            String lastB = ""+b.charAt(b.length()-1);
            return lastA.compareTo(lastB);
        }
    }


    public String sortSentence(String s) {
        s += ' ';
        int len=0;
        for(char ch : s.toCharArray())
            if(ch==' ')
                len++;
        String[] arr = new String[len];
        int m=0;
        int pos = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                arr[pos++] = s.substring(m,i);
                m = i+1;
            }
        }

        // sort
        Arrays.sort(arr,new Comparing());
        StringBuilder ans = new StringBuilder();
        int i=0;
        for (; i<len-1; i++) {
            ans.append(arr[i].substring(0, arr[i].length() - 1));
            ans.append(" ");
        }
        ans.append(arr[i].substring(0, arr[i].length()-1));

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q5().sortSentence("is2 sentence4 This1 a3"));
    }
}
