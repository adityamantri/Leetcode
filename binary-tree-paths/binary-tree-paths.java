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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair(root, ""));
        while(!stack.isEmpty()){
            Pair<TreeNode, String> p = stack.pop();
            String curr = p.getValue();
            TreeNode node = p.getKey();
            if(node != null){
                // leaf node
                if(node.left == null && node.right == null){
                    ans.add(curr+node.val);
                    continue;
                }
                stack.push(new Pair(node.left, curr+node.val+"->"));
                stack.push(new Pair(node.right, curr+node.val+"->"));
            }
        }
        return ans;
    }
}