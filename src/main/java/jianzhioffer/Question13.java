package jianzhioffer;

/**
 * date 17/7/24
 *
 * @author wenle
 */
public class Question13 {

    static class Node {
        int value;
        Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node deleteNodeO1(Node head, Node toBeDeleted) {

        if(head == toBeDeleted) {
            return null;
        }

        if(toBeDeleted.getNext() == null) {

            Node p = head;
            while(p.getNext() != toBeDeleted) {
                p = p.getNext();
            }
            p.setNext(null);
            return head;
        }

        toBeDeleted.setValue(toBeDeleted.getNext().getValue());
        toBeDeleted.setNext(null);
        return head;
    }

}
