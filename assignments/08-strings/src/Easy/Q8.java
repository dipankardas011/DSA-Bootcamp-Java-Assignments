package Easy;

public class Q8 {

    private boolean isVowel(char ch){
        return switch (ch) {
            case 'a' -> true;
            case 'A' -> true;
            case 'e' -> true;
            case 'E' -> true;
            case 'i' -> true;
            case 'I' -> true;
            case 'o' -> true;
            case 'O' -> true;
            case 'u' -> true;
            case 'U' -> true;
            default -> false;
        };
    }

    public boolean halvesAreAlike(String s) {
        int n1 = 0;
        int n2 = 0;

        int start = 0;
        int end = s.length()-1;
        while(start<=end){

            if(isVowel(s.charAt(start)))
                n1++;
            if(isVowel(s.charAt(end)))
                n2++;

            start++;
            end--;
        }

        return n1==n2;
    }
}
