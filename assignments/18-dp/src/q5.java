package src;


public class q5 {


  private int palindromeSize(String s, int left ,int right) {
    //  <---[i]--> expansion
    //  racecar
    //  aabbaa
    if (s==null && left > right)
      return 0;
    while (0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left-1;
  }

  public String longestPalindrome(String s) {
    int start = 0, end= 0;
    for (int i = 0; i < s.length(); i++) {
      int lenEvenExpansion = palindromeSize(s,i,i+1);
      int lenOddExpansion = palindromeSize(s, i, i);
      int len = Math.max(lenOddExpansion, lenEvenExpansion);
      if (len > end-start) {
        start = i - (len-1)/2;
        end = i + (len)/2;
      }
    }
    return s.substring(start, end+1);
  }

  public static void main(String[] args) {
    System.out.println(new q5().longestPalindrome("babad"));
    System.out.println(new q5().longestPalindrome("abb"));
    System.out.println(new q5().longestPalindrome("bba"));
    System.out.println(new q5().longestPalindrome("abbd"));
    System.out.println(new q5().longestPalindrome("bb"));
  }
}
