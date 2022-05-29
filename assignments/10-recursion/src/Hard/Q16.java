package Hard;

public class Q16 {

    private String maxNumber;

    private void utility(char[] arr, int k) {
        if (k == 0)
            return;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    char temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;

                    String st = new String(arr);

                    if (maxNumber.compareTo(st) < 0) {
                        maxNumber = st;
                    }

                    utility(arr, k-1);

                    temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }
    
    public String findMaximumNum(char[] ar, int k) {
        maxNumber = "";
        utility(ar, k);
        return maxNumber;
    }

    public static void main(String[] args) {
        String xx = "129814999";
        System.out.println(new Q16().findMaximumNum(xx.toCharArray(),4));
    }
}
