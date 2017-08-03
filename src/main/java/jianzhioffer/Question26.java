package jianzhioffer;

/**
 * date 17/8/4
 *
 * @author 柏霜
 */
public class Question26 {

    static class Node {

        public int value;
        public Node next;
        public Node sibling;
    }

    public static Node clone(Node head) {

        if (head == null) return null;
        insertCopyNodes(head);
        setSiblings(head);
        return extractCopyList(head);
    }

    private static void insertCopyNodes(Node head) {

        Node p = head;

        while (p != null) {

            Node copy = new Node();
            copy.value = p.value;

            Node origNext = p.next;
            p.next = copy;
            copy.next = origNext;
            p = copy.next;
        }

    }

    private static void setSiblings(Node head) {

        Node p = head;
        while (p != null) {

            if (p.sibling != null) {
                p.next.sibling = p.sibling.next;
            }
            p = p.next.next;
        }
    }

    private static Node extractCopyList(Node head) {

        Node newHead = head.next;

        Node p = head;
        while (p != null) {

            Node copyNode = p.next;
            p.next = copyNode.next;
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            } else {
                copyNode.next = null;
            }
            p = p.next;
        }
        return newHead;
    }

}
