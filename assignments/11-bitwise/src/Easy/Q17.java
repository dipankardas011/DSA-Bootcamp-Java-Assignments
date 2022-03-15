package Easy;

public class Q17 {
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0] = first;

        for (int i = 0 ; i < encoded.length; i++) {
            arr[i+1] = encoded[i] ^ arr[i];
        }
        return arr;
    }
}
