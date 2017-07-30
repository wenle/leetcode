package jianzhioffer;

/**
 * date 17/7/30
 *
 * @author 柏霜
 */
public class ListNode {

    int key;
    ListNode next;

    public boolean hasNext() {
        return next != null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int key) {
        this.key = key;
    }

    public ListNode createAndAppend(int key) {
        ListNode newNode = new ListNode(key);
        this.setNext(newNode);
        return newNode;
    }

    public void printList() {

        ListNode p = this;
        while (p != null) {
            System.out.println(p.getKey());
            p = p.getNext();
        }
    }
}
