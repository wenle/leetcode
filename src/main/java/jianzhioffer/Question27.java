package jianzhioffer;

/**
 * date 17/8/4
 *
 * @author wenle
 */
public class Question27 {

    public static TreeNode convertBST2List(TreeNode root) {


        convertAndReturnLast(null, root);

        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static TreeNode convertAndReturnLast(TreeNode last, TreeNode current) {

        if (current.left != null) {
            last = convertAndReturnLast(last, current.left);
        }

        if (last != null) {
            last.right = current;
        }
        current.left = last;

        if (current.right != null) {
            return convertAndReturnLast(current, current.right);
        } else {
            return current;
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(8, null, null);
        TreeNode node3 = new TreeNode(6, node1, node2);
        TreeNode node4 = new TreeNode(12, null, null);
        TreeNode node5 = new TreeNode(16, null, null);
        TreeNode node6 = new TreeNode(14, node4, node5);
        TreeNode node7 = new TreeNode(10, node3, node6);
        
        TreeNode head = convertBST2List(node7);
        
        System.out.print("Forward: ");
        TreeNode p = head;
        while(true) {
            System.out.print(p.key);
            System.out.print(" ");
            if(p.right == null) {
                break;
            }
            p = p.right;
        }
        
        System.out.println();
        System.out.print("Reverse: ");
        while(true) {
            System.out.print(p.key);
            System.out.print(" ");
            if(p.left == null) {
                break;
            }
            p = p.left;
        }
    }
}
