public class Q4 {

    public int MergeSort(int[] arr, int left, int right) {
        int cnt = 0;
        if (left < right) {
            int mid = left + (right-left)/2;
            cnt += MergeSort(arr, left, mid);
            cnt += MergeSort(arr, mid+1, right);
            cnt += Merger(arr, left, mid, right);
        }
        return cnt;
    }

    private int Merger(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-left + 1];

        int low = left;
        int high = mid+1;
        int k=0;
        int cnt = 0;
        while (low <= mid && high <= right) {
            if (arr[low] < arr[high])
                tmp[k++] = arr[low++];
            else if (arr[low] > arr[high]) {
                tmp[k++] = arr[high++];
                cnt += (mid+1-low);
            }
            else {
                tmp[k++] = arr[low++];
                high++;
            }
        }

        while (low <= mid) {
            tmp[k++]= arr[low++];
        }
        while (high <= right) {
            tmp[k++] = arr[high++];
        }

        for (int i=left; i<=right; i++) {
            arr[i] = tmp[i-left];
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Q4().MergeSort(new int[]{1,9,6,4,5}, 0, 4));
    }
}
