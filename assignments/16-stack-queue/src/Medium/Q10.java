package Medium;

public class Q10 {
    public int leastInterval(char[] tasks, int n) {
        int[] hashMap = new int[26];

        int maxFrequency = -1;
        int numberOfMaxCountElements=0;
        for (Character ch : tasks) {
            hashMap[ch - 'A']++;
            if(maxFrequency == hashMap[ch - 'A']) {
                numberOfMaxCountElements++;
            }
            else if(maxFrequency < hashMap[ch - 'A']) {
                maxFrequency = hashMap[ch - 'A'];
                numberOfMaxCountElements = 1;
            }
        }

        int partitions = maxFrequency - 1; // 3 A's & 3 B's => 2    A _ A _ A
        int partitionLen = n - (numberOfMaxCountElements - 1); // 6 - (2 - 1) = 6-1 => 5  A _ _ A _ _ A here n is size of partition
        // so if we want B to take some space then size of parition will reduce as n - (x)
        // (x) =>> number of palces in each pairtion here 1 so
        // A B _ A B _ A B so one place is remaning and _ is the paritionLen
        int emptySlots = partitionLen*partitions;

        int otherAvailableTasks = tasks.length - maxFrequency*numberOfMaxCountElements;

        int idleTime = Math.max(0, emptySlots - otherAvailableTasks);

        return tasks.length+idleTime;
    }

    public static void main(String[] args) {
        System.out.println(new Q10().leastInterval(new char[]{'A','A','A','B','B', 'B'}, 2));
    }
}
