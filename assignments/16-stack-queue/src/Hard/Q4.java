package Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q4 {
    ArrayList<Integer> rotation(int n){
        // Code Here
        ArrayList<Integer> res = new ArrayList<>();
        int[] arr = new int[1001];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        int i=1;
        while(!q.isEmpty()){
            int j=0;
            while(j<i){
                int x = q.peek();
                q.poll();
                q.add(x);
                j++;
            }
            int x = q.peek();
            if(arr[x] != 0){
                res.add(-1);
                return res;
            }
            arr[x] = i;
            q.poll();
            i++;
        }
        for(i=1; i<=n; i++)
            res.add(arr[i]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q4().rotation(5));
    }
}
