package jianzhioffer;

/**
 * date 17/7/18
 *
 * @author wenle
 */
public class Question16 {

    static class Node {
        int key;
        Node next;

        public boolean hasNext() {
            return next != null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    private static Node createAndAppend(int newKey, Node pre) {

        Node node = new Node();
        node.setKey(newKey);
        node.setNext(null);
        if(pre != null) {
            pre.setNext(node);
        }
        return node;
    }


    public static Node reverseLinkedList(Node head) {

        Node current = head;
        Node pre = null;
        Node next;

        while(current != null) {

            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        Node head = createAndAppend(1, null);
        Node node2 = createAndAppend(2, head);
        Node node3 = createAndAppend(3, node2);
        Node node4 = createAndAppend(4, node3);
        Node node5 = createAndAppend(5, node4);

        Node reversedHead = reverseLinkedList(head);
        Node p = reversedHead;
        while(p!=null) {
            System.out.println(p.getKey());
            p = p.getNext();
        }



    }

}
