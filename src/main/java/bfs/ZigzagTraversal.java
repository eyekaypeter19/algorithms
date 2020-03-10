package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> processingQueue = new LinkedList<>();
        processingQueue.offer(root);
        boolean startFromLeft = false;
        while(!processingQueue.isEmpty()) {
            int levelSize =  processingQueue.size();
            List<Integer> currentLevel = new LinkedList<Integer>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = processingQueue.poll();
                if (startFromLeft)
                    currentLevel.add(0, node.val);
                else
                    currentLevel.add(node.val);
                if (node.left != null)
                    processingQueue.offer(node.left);
                if(node.right != null)
                    processingQueue.offer(node.right);
            }
            startFromLeft = !startFromLeft;
            result.add(currentLevel);

        }
        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}