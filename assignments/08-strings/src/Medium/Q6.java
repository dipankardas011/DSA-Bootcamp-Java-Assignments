package Medium;

public class Q6 {
    public int nextGreaterElement(int n) {
        char[] a=(""+n).toCharArray();

        int i=a.length-2;
        while(i>=0 && a[i+1] <= a[i])
            i--;

        if (i < 0)
            return -1;

        int j=a.length - 1;

        while (j >= 0 && a[j] <= a[i])
            j--;

        swap(a,i,j);

        int l = i + 1;
        int r = a.length-1;
        while (l < r) {
            swap(a,l,r);
            l++;
            r--;
        }

        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void main(String[] args) {
        Q6 ob = new Q6();
        System.out.println(ob.nextGreaterElement(21));
        System.out.println(ob.nextGreaterElement(12));
        System.out.println(ob.nextGreaterElement(23432423));
    }
}
