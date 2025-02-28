/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(right == null) return left;
        else if(left == null) return right;
        return root;
    }
}

/**
[3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        3
    5         1
6       2  0     8
       7 4
    

*/