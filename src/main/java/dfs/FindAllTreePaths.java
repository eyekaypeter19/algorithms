package dfs;

import bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        if(root.val == sum && root.left == null && root.right == null) {
            currentPath.add(root.val);
            allPaths.add(currentPath);
            return allPaths;
        }

        findPathsRecursive(root, sum, allPaths,currentPath);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode treeNode, int sum,
                                                   List<List<Integer>> allPaths,
                                                   List<Integer> currentPath) {
        if(treeNode == null)
            return;
        currentPath.add(treeNode.val);
        if(treeNode.val == sum && treeNode.right == null && treeNode.left == null) {
            allPaths.add(new ArrayList<>(currentPath));
        }
        else {
            findPathsRecursive(treeNode.left, sum - treeNode.val, allPaths, currentPath);
            findPathsRecursive(treeNode.right, sum - treeNode.val, allPaths, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}