package Week2;

class VersionControl {
    public boolean isBadVersion(int n) {
        return n >= 4;
    }
}

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int savePoint = 1;
        while (l <= r) {
            int mid= l + (r-l)/2;
            if (isBadVersion(mid)) {
                savePoint = mid;  // get the first error version
                r = mid-1;
            } else {
                // get the last working version
                l = mid+1;
            }
        }
        return savePoint;
    }

    public static void main(String[] args) {
        FirstBadVersion obj = new FirstBadVersion();
        System.out.println(obj.firstBadVersion(5));
    }
}