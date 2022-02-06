package Easy;

public class Q4 {
    private void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void reverseString(char[] s) {

        int l=0;
        int r = s.length-1;
        while (l < r) {

            swap(s,l,r);

            l++;
            r--;
        }
    }
}
