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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    
    public int depth(TreeNode node){
        if(node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        max = Math.max(max, left+right); // we dont include +1 here for root node because it is asking for no. of EDGES, not nodes.
        return Math.max(left, right) + 1;
    }
}