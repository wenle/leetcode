package jianzhioffer;

/**
 * date 17/7/18
 *
 * @author wenle
 */
public class Question15 {

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

    public static int getValueOfLastKthNode(Node head, int k) {

        Node p = head;
        Node kNode = null;
        int count = 0;
        while(p != null) {
            count ++;
            if(count == k) {
                kNode = head;
            } else if(kNode != null) {
                kNode = kNode.getNext();
            }
            p = p.getNext();
        }
        if(kNode != null) {
            return kNode.getKey();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static int getValueOfLastKthNode2(Node head, int k) {

        Node p = head;
        for(int i=0;i<k-1;i++) { // 移动到第k个
            p = p.getNext();
        }
        Node lastKth = head;
        
        while(p.hasNext()) {
            p = p.getNext();
            lastKth = lastKth.getNext();
        }
        
        return lastKth.getKey();
    }

    public static void main(String[] args) {

        Node head = createAndAppend(1, null);
        Node node2 = createAndAppend(2, head);
        Node node3 = createAndAppend(3, node2);
        Node node4 = createAndAppend(4, node3);
        Node node5 = createAndAppend(5, node4);

        System.out.println(getValueOfLastKthNode(head, 1));
        System.out.println(getValueOfLastKthNode(head, 2));
        System.out.println(getValueOfLastKthNode(head, 3));
        System.out.println(getValueOfLastKthNode(head, 4));
        System.out.println(getValueOfLastKthNode(head, 5));


        System.out.println(getValueOfLastKthNode2(head, 1));
        System.out.println(getValueOfLastKthNode2(head, 2));
        System.out.println(getValueOfLastKthNode2(head, 3));
        System.out.println(getValueOfLastKthNode2(head, 4));
        System.out.println(getValueOfLastKthNode2(head, 5));
    }

}
