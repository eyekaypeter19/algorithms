package dfs;

import bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        if (root == null)
            return 0;
        Integer currentSum = 0;
        List<Integer> currentPath = new ArrayList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode node, int pathSum, List<Integer> currentPath) {
        if(node == null)
            return 0;
        currentPath.add(node.val);
        Integer currentSum = 0;
        if(node.val == pathSum) {
            currentSum += 1;
            return currentSum;
        }
        if(node.left != null) {
            currentSum += countPathsRecursive(node.left, pathSum - node.val, currentPath);
            currentSum += countPathsRecursive(node.left, pathSum, new ArrayList<>());
        }

        if(node.right != null) {
            currentSum += countPathsRecursive(node.right, pathSum - node.val, currentPath);
            currentSum += countPathsRecursive(node.right, pathSum, new ArrayList<>());
        }
        currentPath.remove(currentPath.size() - 1);
        return currentSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}