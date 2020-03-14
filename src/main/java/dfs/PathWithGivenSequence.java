package dfs;

import bfs.TreeNode;

class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null || sequence == null || sequence.length == 0)
            return false;

        int currentLevel = 0;
        return findPathRecursive(root, sequence, currentLevel);
    }

    private static boolean findPathRecursive(TreeNode node, int[] sequence, int currentLevel) {

        if (node.left != null && node.right != null && node.val == sequence[currentLevel]) {
            return findPathRecursive(node.left, sequence, currentLevel + 1) ||
                    findPathRecursive(node.right, sequence, currentLevel + 1);
        } else if (node.left == null && node.right == null && sequence[currentLevel] == node.val) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
