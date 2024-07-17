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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }
        root = processNode(root, set, forest);
        if(root != null){
            forest.add(root);
        }
        return forest;
    }

    private TreeNode processNode(TreeNode node, Set<Integer> set, List<TreeNode> forest){
        if(node == null){
            return null;
        }
        node.left = processNode(node.left, set, forest);
        node.right = processNode(node.right, set, forest);
        if(set.contains(node.val)){
            if(node.left != null){
                forest.add(node.left);
            }
            if(node.right != null){
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }
}