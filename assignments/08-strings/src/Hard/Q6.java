package Hard;

import java.util.ArrayList;

public class Q6 {
    public boolean isTransformable(String s, String t) {
        ArrayList<Integer>[] idx = new ArrayList[10];
        int pos[] = new int[10];
        for (int i = 0; i <= 9; ++i)
            idx[i] = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); ++i)
            idx[s.charAt(i) - '0'].add(i);
        
        for (int i = 0; i < t.length(); ++i) {
            int d = t.charAt(i) - '0';
            if (pos[d] >= idx[d].size())
                return false;

            for (int j = 0; j < d; ++j)
                if (pos[j] < idx[j].size() &&
                    idx[j].get(pos[j]) < idx[d].get(pos[d]))
                    return false;

            ++pos[d];
        }
        return true;
    }
    
    public static void main(String[] args) {
        Q6 o = new Q6();
        System.out.println(o.isTransformable("84532", "34852"));
    }
}
