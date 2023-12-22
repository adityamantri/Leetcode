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
        if(root == null) return res;
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int minCol = 0, maxCol = 0;
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode n = p.getKey();
            int col = p.getValue();
            if(n == null) continue;
            
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            colMap.putIfAbsent(col, new ArrayList<>());
            colMap.get(col).add(n.val);

            queue.offer(new Pair(n.left, col-1));
            queue.offer(new Pair(n.right, col+1));
        }

        while(minCol <= maxCol){
            res.add(colMap.get(minCol++));
        }
        return res;
    }
}

    // -1  0   1   2
    //     3
    // 9       20
    //     15      7

// 1. attach column numbers to nodes
// 2. add the node.val to the columnMap<col_no, List(node.val)>
// 3. Keep a track of min and max col idx while traversal
