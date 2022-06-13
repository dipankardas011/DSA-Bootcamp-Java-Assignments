package Medium;

public class Q14 {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println("BACK(1) -> "+browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println("BACK(1) -> "+browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println("FORWARD(1) -> "+browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println("FORWARD(2) -> "+browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println("BACK(2) -> "+browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println("BACK(7) -> "+browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

class node<E> {
    node<E> prev, next;
    E url;

    node(E url, node<E> NXT) {
        this.prev = null;
        this.url = url;
        this.next = NXT;
    }
}
class BrowserHistory {

    node<String> List;

    public BrowserHistory(String homepage) {
        List = new node<>(homepage, null);
    }

    public void visit(String url) {
        if(List.prev != null) {
            List.prev = null;
        }
        node<String> temp = List;
        List = new node<>(url, List);
        temp.prev = List;
    }

    public String back(int steps) {
        while (steps-- > 0 && List.next!=null)
            List = List.next;
        return List.url;
    }

    public String forward(int steps) {
        while (steps-- > 0 && List.prev != null)
            List = List.prev;
        return List.url;
    }
}
