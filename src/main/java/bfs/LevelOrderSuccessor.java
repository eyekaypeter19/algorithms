package bfs;

import java.util.LinkedList;
import java.util.Queue;


class TreeNodeV2 extends TreeNode{
    TreeNode next;

    TreeNodeV2(int x) {
        super(x);
        left = right = next = null;
    }
}

class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if(root == null)
            return null;
        TreeNode levelOrderSuccessor = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isNextNodeSuccessor = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
                TreeNode currentNode = queue.poll();
                if (currentNode == null)
                    return null;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (currentNode.val == key)
                {
                    levelOrderSuccessor = queue.poll();
                }

        }
        return levelOrderSuccessor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
