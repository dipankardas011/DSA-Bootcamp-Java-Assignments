import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {

    /**
     * As the array is not sorted and if it is sorted
     * 1,1,2,4,7,8
     * then pop() 2 elements and store the res back to stack
     * as the top element is largest of stack so we gonna use heaps i.e. MAX HEAP
     * @param stones stones with respective weights
     * @return int
     */
    public int lastStoneWeight(int[] stones) {
        // MAX HEAP
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b)-> b - a);

        for (int ele : stones)
            priorityQueue.add(ele);
        System.out.println(Arrays.toString(priorityQueue.toArray()));
        while (priorityQueue.size() > 1) {
            priorityQueue.add(priorityQueue.poll() - priorityQueue.poll());
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
