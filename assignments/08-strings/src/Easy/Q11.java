package Easy;

public class Q11 {
    public boolean judgeCircle(String moves) {
        int i=0;
        int j=0;
        for(char move : moves.toCharArray()){
            switch (move) {
                case 'L' -> j--;
                case 'R' -> j++;
                case 'U' -> i--;
                case 'D' -> i++;
            }
        }
        return i == 0 && j == 0;
    }
}
