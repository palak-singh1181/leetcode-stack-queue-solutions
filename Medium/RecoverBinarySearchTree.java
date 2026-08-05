public class RecoverBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);

        if (prev != null && prev.val > node.val) {

            if (first == null)
                first = prev;

            second = node;
        }

        prev = node;

        inorder(node.right);
    }

    public static void inorderPrint(TreeNode root) {
        if (root == null)
            return;

        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {

        // Wrong BST:
        //      3
        //     / \
        //    1   4
        //       /
        //      2

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();

        System.out.print("Before Recovery: ");
        inorderPrint(root);

        obj.recoverTree(root);

        System.out.print("\nAfter Recovery : ");
        inorderPrint(root);
    }
}