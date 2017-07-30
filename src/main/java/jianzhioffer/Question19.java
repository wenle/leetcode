package jianzhioffer;

/**
 * date 17/7/18
 *
 * @author wenle
 */
public class Question19 {

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

    public static void mirrorTree(TreeNode root) {

        if(root == null || (root.getLeft() ==null && root.getRight() == null)) {
            return;
        }

        TreeNode temp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(temp);

        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());
    }

}
