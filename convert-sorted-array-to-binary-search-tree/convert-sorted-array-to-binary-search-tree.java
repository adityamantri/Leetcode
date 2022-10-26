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
    
    public TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = (left+right) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid-1);
        node.right = helper(nums, mid+1, right);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int rootIdx = (nums.length) / 2;
        TreeNode root = new TreeNode(nums[rootIdx]);
        return helper(nums, 0, nums.length-1);
    }
}