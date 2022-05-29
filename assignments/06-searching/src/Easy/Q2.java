package Easy;

public class Q2 {
    int bad;
    public boolean isBadVersion(int x) {
        return x==bad;
    }

    public int firstBadVersion(int n) {
        // use binary search as it is sorted 1, 2, 3, 4.. n
        int end = n;
        int start = 1;
        while (start < end) {
            // case 1: if mid is false means we need to go =>
            // case 2: if mid is true means we need to go <= as further
            // bad we can find
            int mid = start + (end - start) / 2 ;
            if (!isBadVersion(mid))
                start = mid+1; // mid + 1 as to leave the current mid as it is not possible answer
            else
                end = mid;// not mid -1 as end is the possible ans
        }
        return start;
    }


    public static void main(String[] args) {
        Q2 test = new Q2();
        test.bad = 2;
        System.out.println(test.firstBadVersion(3));
    }
}
