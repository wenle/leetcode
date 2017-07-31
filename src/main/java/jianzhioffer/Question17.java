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

        if (head1.key <= head2.key) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
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
                pre.next = p2;
                break;
            }
            if (p2 == null) {
                pre.next = p1;
                break;
            }
            ListNode small = (p1.key <= p2.key) ? p1 : p2;
            if (head == null) {
                head = small;
                pre = head;
            } else {
                pre.next = small;
                pre = small;
            }

            if (p1.key <= p2.key) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
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
