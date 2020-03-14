package dfs;

import bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        if (root == null)
            return -1;
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findSumOfPathNumbers(root, currentPath, allPaths);
        return sum(allPaths);
    }

    private static void findSumOfPathNumbers(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if(currentNode == null)
            return;
        currentPath.add(currentNode.val);
        if(currentNode.left == null && currentNode.right == null)
        {
            allPaths.add(new ArrayList<>(currentPath));
        }
        else {
            findSumOfPathNumbers(currentNode.left, currentPath, allPaths);
            findSumOfPathNumbers(currentNode.right, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    private static int sum(List<List<Integer>> allPaths) {
        Integer allSums = 0;
        for(List<Integer> path : allPaths) {
            Integer currentSum = 0;
            System.out.println(path);
            for(int i = 0; i < path.size(); i ++) {
                currentSum = path.get(i) + (currentSum * 10);
            }
            System.out.println(currentSum);
            allSums += currentSum;
        }
        return allSums;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}