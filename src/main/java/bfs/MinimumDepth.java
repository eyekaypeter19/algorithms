package bfs;

import java.util.LinkedList;
import java.util.Queue;

class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        int minimumDepth = 1;
        if(root == null || root.left == null || root.right == null)
            return minimumDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left == null && currentNode.right == null) {
                    return minimumDepth;
                }
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            minimumDepth += 1;
        }
        return minimumDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}