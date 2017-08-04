package jianzhioffer;

/**
 * date 17/7/30
 *
 * @author wenle
 */
public class TreeNode {

    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int key) {
        this.key = key;
    }


    public TreeNode(int key, TreeNode left, TreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
