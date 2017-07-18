package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * date 17/7/18
 *
 * @author wenle
 */
public class Question6 {

    static class Node {
        int value;
        Node left;
        Node right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static Node rebuildTree(List<Node> preorder, List<Node> inorder) {

        if(preorder == null || preorder.isEmpty()) {
            return null;
        }
        Node root = preorder.get(0);

        int leftLen=0, rightLen=0;
        for(int i=0; i<inorder.size();i++) {
            if(inorder.get(i).getValue() == root.getValue()) {
                leftLen = i;
                rightLen = preorder.size()-i-1;
                break;
            }
        }


        List<Node> leftPreorder = preorder.subList(1, 1+leftLen);
        List<Node> leftInorder = inorder.subList(0, leftLen);
        List<Node> rightPreorder = preorder.subList(1+leftLen, preorder.size());
        List<Node> rightInorder = inorder.subList(leftLen+1, inorder.size());
        Node leftRoot = rebuildTree(leftPreorder, leftInorder);
        Node rightRoot = rebuildTree(rightPreorder, rightInorder);
        root.setLeft(leftRoot);
        root.setRight(rightRoot);
        return root;
    }

    private static List<Node> createNodeList(int[] values) {

        List<Node> list = new ArrayList<>();
        for(int v : values) {

            Node node = new Node();
            node.setValue(v);
            node.setLeft(null);
            node.setRight(null);
            list.add(node);
        }
        return list;
    }
    public static void main(String[] args) {

        List<Node> preorder = createNodeList(new int[]{1, 2, 4, 7, 3, 5, 6, 8});
        List<Node> inorder = createNodeList(new int[] {4, 7, 2, 1, 5, 3, 8, 6});

        Node root = rebuildTree(preorder, inorder);
        printAfterorder(root);
    }

    private static void printAfterorder(Node root) {

        if(root == null) {
            return;
        }
        printAfterorder(root.getLeft());
        printAfterorder(root.getRight());

        StringBuilder builder = new StringBuilder();
        builder.append(root.getValue());
        builder.append(" ==> ");
        String left = root.getLeft() == null ? "null" : String.valueOf(root.getLeft().getValue());
        String right = root.getRight() == null ? "null" : String.valueOf(root.getRight().getValue());
        builder.append(left);
        builder.append(" : ");
        builder.append(right);
        System.out.println(builder);
    }

}
