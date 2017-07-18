package jianzhioffer;

import java.util.Stack;

/**
 * date 17/7/18
 *
 * @author wenle
 */
public class Question5 {

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

    public static void reversePrint(Node head) {

        if(head == null) {
            return;
        } else {
            reversePrint(head.getNext());
            System.out.println(head.getKey());
        }
    }

    public static void reversePrint2(Node head) {

        Stack<Node> s = new Stack<>();
        Node p = head;
        while(p != null) {
            s.push(p);
            p = p.getNext();
        }
        while(!s.empty()) {
            System.out.println(s.pop().getKey());
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

    public static void main(String[] args) {

        Node head = createAndAppend(1, null);
        Node node2 = createAndAppend(2, head);
        Node node3 = createAndAppend(3, node2);
        Node node4 = createAndAppend(4, node3);
        Node node5 = createAndAppend(5, node4);

        reversePrint(head);
        reversePrint2(head);
    }

}
