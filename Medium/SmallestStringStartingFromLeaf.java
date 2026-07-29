
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SmallestStringStartingFromLeaf {

    static String ans = "~";

    public static String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private static void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            String curr = sb.reverse().toString();
            sb.reverse();

            if (curr.compareTo(ans) < 0) {
                ans = curr;
            }
        }

        dfs(node.left, sb);
        dfs(node.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {

        // Example:
        //      0
        //     / \
        //    1   2
        //   / \ / \
        //  3  4 3  4

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println("Smallest String: " + smallestFromLeaf(root));
    }
}