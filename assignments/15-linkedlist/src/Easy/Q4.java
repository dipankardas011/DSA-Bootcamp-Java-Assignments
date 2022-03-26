package Easy;
import construct.LinkList;

public class Q4 extends LinkList{
    LinkList.ListNode hh = null;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        LinkList merged = new LinkList();
        while (list1 != null && list2 != null) {

            if (list1.value < list2.value) {
                 merged.push(list1.value);
                list1 = list1.next;
            } else if (list1.value > list2.value) {
                merged.push(list2.value);
                list2 = list2.next;
            } else {
                merged.push(list1.value);
                merged.push(list2.value);
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            merged.push(list1.value);
            list1 = list1.next;
        }

        while (list2 != null) {
            merged.push(list2.value);
            list2 = list2.next;
        }
        hh = merged.getHead();
        return merged.getHead();
    }
    public static void main(String[] args) {
        LinkList l1 = new LinkList();
        l1.push(1);
        l1.push(2);
        l1.push(4);
        l1.display();

        LinkList l2 = new LinkList();
        l2.push(1);
        l2.push(3);
        l2.push(4);
        l2.display();
        Q4 o = new Q4();
        System.out.println(o.mergeTwoLists(l1.getHead(), l2.getHead()).value);
        l1 = l1.copyLinkList(o.hh);
        l1.display();
    }


    public ListNode mergeTwoListsLeetCode(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.value < l2.value){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
