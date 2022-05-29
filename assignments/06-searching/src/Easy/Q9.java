package Easy;

public class Q9 {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // inside descending series
                end = mid;
                // because the possible answer is mid not mid - 1
            }
            else {
                // inside the ascending
                start = mid + 1;
            }
        }
        return end;
    }
}
