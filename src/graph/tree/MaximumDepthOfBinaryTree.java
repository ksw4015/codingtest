package graph.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);

        int depth = 0;
//        while (!queue.isEmpty()) {
//            depth += 1;
//            int qSize = queue.size();  // 큐 사이즈 만큼 반복 중요
//            for(int i = 0 ; i < qSize ; i++) { // 큐 사이즈 만큼 반복해야 해당 Level의 노드를 전부 탐색
//                TreeNode cur = queue.poll();
//                if(cur.left != null)
//                    queue.add(cur.left);
//                if(cur.right != null)
//                    queue.add(cur.right);
//            }
//        }

        /*
         재귀 풀이(DFS)
         */
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        depth = Math.max(left, right) + 1;  // root 노드 개수 1 더함
        
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }

}
