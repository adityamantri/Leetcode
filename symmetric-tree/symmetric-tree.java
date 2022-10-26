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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) 
            return true;
        return recurse(root.left, root.right);
    }
    
    public boolean recurse(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        
        return recurse(left.left, right.right) && recurse(left.right, right.left);
    }
    
}