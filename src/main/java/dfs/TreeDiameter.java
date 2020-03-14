package dfs;

import bfs.TreeNode;

public class TreeDiameter {

    private static int maxTreeDiameter = 0;

    public static int findDiameter(TreeNode root) {
        if(root == null)
            return 0;

        findDiameterRecursive(root);

        return maxTreeDiameter;
    }

    private static int findDiameterRecursive(TreeNode root) {

        if(root == null)return 0;

        int leftTreeHeight = findDiameterRecursive(root.left);
        int rightThreeHeight = findDiameterRecursive(root.right);
        int diameter = (leftTreeHeight + rightThreeHeight + 1);
        maxTreeDiameter = Math.max(diameter, maxTreeDiameter);
        return Math.max(leftTreeHeight, rightThreeHeight) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}

