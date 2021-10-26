package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class Q7 {
    public int[] findRightInterval(int[][] intervals) {
        int[] ans=new int[intervals.length];

        int[] start=new int[intervals.length];
        HashMap<Integer,Integer> idxValues=new HashMap<>();

        for(int i=0;i<intervals.length;i++){
            ans[i]=-1;
        }

        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i][0];
            idxValues.put(start[i],i);
        }

        Arrays.sort(start);

        int i=0;

        while(i<intervals.length){
            int checkInt=intervals[i][1];

            int begin=0;
            int end=start.length-1;

            while(begin<=end){
                int mid=begin+(end-begin)/2;

                if(start[mid]>=checkInt){
                    ans[i]=idxValues.get(start[mid]);
                    end=mid-1;
                }
                else if(start[mid]<checkInt){
                    begin=mid+1;
                }
            }

            i++;
        }

        return ans;
    }
}
