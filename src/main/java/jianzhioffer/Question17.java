package jianzhioffer;

/**
 * date 17/7/30
 *
 * @author wenle
 */
public class Question17 {

    public static ListNode merge(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.getKey() <= head2.getKey()) {
            head1.setNext(merge(head1.getNext(), head2));
            return head1;
        } else {
            head2.setNext(merge(head1, head2.getNext()));
            return head2;
        }
    }

    private static ListNode merge2(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        ListNode p1 = head1;
        ListNode p2 = head2;

        ListNode head = null;
        ListNode pre = null;
        while (true) {

            if (p1 == null) {
                pre.setNext(p2);
                break;
            }
            if (p2 == null) {
                pre.setNext(p1);
                break;
            }
            ListNode small = (p1.getKey() <= p2.getKey()) ? p1 : p2;
            if (head == null) {
                head = small;
                pre = head;
            } else {
                pre.setNext(small);
                pre = small;
            }

            if (p1.getKey() <= p2.getKey()) {
                p1 = p1.getNext();
            } else {
                p2 = p2.getNext();
            }
        }
        return head;
    }


    public static void main(String[] args) {


        ListNode head1 = new ListNode(1);
        head1.createAndAppend(3)
                .createAndAppend(5)
                .createAndAppend(7)
                .createAndAppend(9);


        ListNode head2 = new ListNode(2);
        head2.createAndAppend(4)
                .createAndAppend(6)
                .createAndAppend(8)
                .createAndAppend(10);

        ListNode p = merge(head1, head2);
        p.printList();
    }

}
