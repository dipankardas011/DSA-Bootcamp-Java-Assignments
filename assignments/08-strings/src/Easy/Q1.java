package Easy;

public class Q1 {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();

        int s = 0;
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i)=='.'){
                res.append(address.substring(s, i)).append("[.]");
                s = i+1;
            }
        }
        res.append(address.substring(s));

        return res.toString();
    }
}
