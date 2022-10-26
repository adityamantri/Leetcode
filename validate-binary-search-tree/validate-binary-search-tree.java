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
    
    public boolean recurse(TreeNode root, long lLimit, long rLimit){
        if(root == null){
            return true;
        }
        
        if(root.val <= lLimit || root.val >= rLimit){
            return false;
        }
        
        boolean isLeftValid = recurse(root.left, lLimit, root.val);
        boolean isRightValid = recurse(root.right, root.val, rLimit);
        
        return isLeftValid && isRightValid;
    }
    
    public boolean isValidBST(TreeNode root) {
        return recurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

/**
    Approach 1:
    create an Inorder array and check if the array is in increasing order
    T: O(n)
    S: O(n)
        where n is the no of nodes
        
    Approach 2:
    Keep a track of parents -> parent to know the child limits.
*/