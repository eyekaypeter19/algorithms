package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeBoundary {
    public static List<TreeNode> findBoundary(TreeNode root) {
        List<TreeNode>result = new ArrayList<>();
        if(root == null || (root.left == null && root.right == null))
        {
            result.add(root);
            return result;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        List<TreeNode> rightSide = new LinkedList<>();
        List<TreeNode> leftSide = new LinkedList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if(i == 0 && i == size - 1){
                    leftSide.add( currentNode);
                } else if (i == 0) {
                    rightSide.add(0, currentNode);
                } else if (i == size - 1) {
                    leftSide.add(currentNode);
                } else if(currentNode.left == null && currentNode.right == null) {
                    leftSide.add(currentNode);
                }
                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
        result.addAll(leftSide);
        result.addAll(rightSide);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = TreeBoundary.findBoundary(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}