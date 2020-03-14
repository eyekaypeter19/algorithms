package dfs;

import bfs.TreeNode;

public class MaximumPathSum {


    private static int maximumSum = 0;

    public static int findMaximumPathSum(TreeNode root) {
        maximumSum = 0;
        findSumRecursive(root);
        return maximumSum;
    }

    private static int findSumRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = findSumRecursive(root.left);
        int rightSum = findSumRecursive(root.right);
        int pathSum = leftSum + rightSum + root.val;
        maximumSum = Math.max(pathSum, maximumSum);
        return Math.max(leftSum, rightSum) + root.val;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}