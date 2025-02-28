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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minCol = 0, maxCol = 0;
        int row = 0;
        if(root == null) return res;
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Pair<Integer, TreeNode> p = q.poll();
                int col = p.getKey();
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                TreeNode n = p.getValue();
                map.computeIfAbsent(col, k-> new ArrayList<>()).add(n.val);
                if(n.left != null){
                    q.offer(new Pair(col-1, n.left));
                }
                if(n.right != null){
                    q.offer(new Pair(col+1, n.right));
                }
            }
        }
        while(minCol <= maxCol){
            res.add(map.get(minCol++));
        }
        return res;
    }
}