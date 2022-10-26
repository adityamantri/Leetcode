/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private static int findMaxDepth(TreeNode root, int depth){
        if(root == null) return depth;
        int leftDepth = findMaxDepth(root.left, depth+1);
        int rightDepth = findMaxDepth(root.right, depth+1);
        return Math.max(leftDepth, rightDepth);
    }
    
    public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 0);
    }
}