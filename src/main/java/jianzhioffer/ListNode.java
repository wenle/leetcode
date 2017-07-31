package jianzhioffer;

/**
 * date 17/7/30
 *
 * @author wenle
 */
public class ListNode {

    public int key;
    public ListNode next;

    public ListNode(int key) {
        this.key = key;
    }

    public ListNode createAndAppend(int key) {
        ListNode newNode = new ListNode(key);
        this.next = newNode;
        return newNode;
    }

    public void printList() {

        ListNode p = this;
        while (p != null) {
            System.out.println(p.key);
            p = p.next;
        }
    }
}
