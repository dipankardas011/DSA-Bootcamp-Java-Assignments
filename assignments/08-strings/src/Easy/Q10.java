package Easy;

public class Q10 {
    public int numOfStrings(String[] patterns, String word) {
        int ans=0;
        for (String str : patterns) {
            if(word.contains(str)) // if the pattern[i] is substring of word
                // so comparing that if word contains the pattern[i] "abc".contains("a")
                ans++;
        }

        return ans;
    }
}
