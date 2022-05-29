package Easy;

public class Q12 {
    public String reverseWords(String s) {
        s += ' ';
        int m = 0;
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){

                String word = s.substring(m, i);
                for(int j=word.length()-1; j>=0; j--){
                    str.append(word.charAt(j));
                }
                str.append(' ');

                m = i+1;
            }
        }

        return str.substring(0,str.length()-1).toString();
    }
}
