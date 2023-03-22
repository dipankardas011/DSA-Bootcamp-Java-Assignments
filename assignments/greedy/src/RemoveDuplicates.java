import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicateLetters(String s) {
        int[] lastSeen = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i)-'a'] = i;
        }
        // after storing the last seen we can get to know when to add the duplicate delement
        // HINT is to add at the last occurrence so as to make it lexocically small
        boolean[] visited = new boolean[26];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int indexChar = ch - 'a';
            if (visited[indexChar])
                continue;

            while (!stk.isEmpty() &&
                    stk.peek() > indexChar &&
                    i < lastSeen[stk.peek()]) {
                visited[stk.pop()] = false;
            }

            stk.push(indexChar);
            visited[indexChar] = true;
        }
        StringBuilder ret = new StringBuilder();

        while (!stk.isEmpty()) {
            ret.append((char) (stk.pop() + 'a'));
        }
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new RemoveDuplicates().
                        removeDuplicateLetters("cbacdcbc")
        );
    }
}
