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

    public List<TreeNode> allBST(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>> memo){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        if(memo.containsKey(new Pair<>(start, end))){
            return memo.get(new Pair<>(start, end));
        }

        for(int root = start; root <= end; root++){
            List<TreeNode> leftSubTree = allBST(start, root-1, memo);
            List<TreeNode> rightSubTree = allBST(root+1, end, memo);
            for(TreeNode left : leftSubTree){
                for(TreeNode right : rightSubTree){
                    TreeNode node = new TreeNode(root, left, right);
                    res.add(node);
                }
            }
        }
        memo.put(new Pair<>(start, end), res);
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
        return allBST(1, n, memo);
    }
}