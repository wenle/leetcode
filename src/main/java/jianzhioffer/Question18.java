package jianzhioffer;

/**
 * date 17/7/18
 *
 * @author wenle
 */
public class Question18 {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static boolean containsSubTree(TreeNode root1, TreeNode root2) {

        boolean result = false;
        if (root1 == null) {
            return false;
        } else {
            if (root1.getValue() == root2.getValue()) {
                result = compare(root1, root2);
            }
        }


        if (root1.getLeft() != null) {
            result = containsSubTree(root1.getLeft(), root2);
        }
        if (!result && root1.getRight() != null) {
            result = containsSubTree(root1.getRight(), root2);
        }
        return result;
    }

    private static boolean compare(TreeNode root1, TreeNode root2) {

        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.getValue() != root2.getValue()) {
            return false;
        }
        return compare(root1.getLeft(), root2.getLeft()) && compare(root1.getRight(), root2.getRight());

    }


}
