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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        recurse(root);
        return max;
    }

    public int recurse(TreeNode root){
        if(root == null) return 0;
        int leftSum = Math.max(0, recurse(root.left));
        
        int rightSum = Math.max(0, recurse(root.right));
        max = Math.max(root.val + leftSum+rightSum, max);
        return Math.max(leftSum, rightSum) + root.val;
    }
}