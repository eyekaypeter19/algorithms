package bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for(int i =0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            var average = calculateAverage(currentLevel);
            result.add(average);
        }
        return result;
    }

    private static Double calculateAverage(List<Integer> result) {
        Double sum = Double.valueOf(0);
        for(Integer n : result) {
            sum += Double.valueOf(n);
        }
        int size = result.size();
        return sum/size;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}