package Medium;

public class Q8 {

    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        int ptrStart = 0, ptrEnd = 0;

        while (ptrStart < start.length() && ptrEnd < end.length()) {

            while (ptrStart < start.length() && start.charAt(ptrStart) == 'X') ptrStart++;

            while (ptrEnd < end.length() && end.charAt(ptrEnd) == 'X') ptrEnd++;

            if (ptrStart==start.length() && ptrEnd==end.length())
                return true;
            if (ptrStart==start.length() || ptrEnd==end.length())
                return false;

            if (start.charAt(ptrStart) != end.charAt(ptrEnd))
                return false;

            if (start.charAt(ptrStart) == 'L' && ptrEnd > ptrStart)  // the pS must be greater pE as XL {S} => LX {E}
                return false;
            if (start.charAt(ptrStart) == 'R' && ptrStart > ptrEnd) // RX {S} => XR {E}
                return false;

            ptrEnd++;
            ptrStart++;
        }
        return true;
    }

    public static void main(String[] args) {
        Q8 ob = new Q8();
        System.out.println(ob.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(ob.canTransform("RXR", "XXR"));
    }
}
