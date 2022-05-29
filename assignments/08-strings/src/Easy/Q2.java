package Easy;


public class Q2 {
    String restoreString(String s, int[] indices) {
        char[] ss = s.toCharArray();
        for(int i=0;i<indices.length;i++) {
            while(indices[i]!=i) {
                swap(ss, i, indices[i]);
                swap(indices, i,indices[i]);
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        for(char ch : ss){
            sBuilder.append(ch);
        }
        s = sBuilder.toString();
        return s;
    }

    private void swap(char[] ss, int s, int s1) {
        char t = ss[s];
        ss[s] = ss[s1];
        ss[s1] = t;
    }
    private void swap(int[] ss, int s, int s1) {
        int t = ss[s];
        ss[s] = ss[s1];
        ss[s1] = t;
    }

    public static void main(String[] args) {
        System.out.println(new Q2().restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
}
