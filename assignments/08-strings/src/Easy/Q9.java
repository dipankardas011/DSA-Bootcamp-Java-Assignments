package Easy;

public class Q9 {
    public String freqAlphabets(String s) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length();){
            if(i+2<s.length() && s.charAt(i+2)=='#') {
                int ss=(s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
                str.append((char)(ss+'a'-1));
                i+=3;
            }
            else {
                str.append((char)(s.charAt(i)-'0'-1+'a'));
                ++i;
            }
        }

        return str.toString();
    }
}
