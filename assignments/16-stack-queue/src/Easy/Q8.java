package Easy;

import java.util.Stack;

public class Q8 {
    public void deleteMid(Stack<Integer> s, int sizeOfStack){

        if (s.size() == Math.ceil(sizeOfStack/2.0)) {
            s.pop();
            return;
        }

        int x = s.pop();

        deleteMid(s, sizeOfStack);

        s.push(x);
    }
}
