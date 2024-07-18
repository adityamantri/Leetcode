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

    private void traverseTree(TreeNode curr, TreeNode prev, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> leafNodes){
        if(curr == null) return;
        if(curr.left == null && curr.right == null){
            leafNodes.add(curr);
        }
        if(prev != null){
            graph.computeIfAbsent(prev, k -> new ArrayList<>());
            graph.get(prev).add(curr);
            graph.computeIfAbsent(curr, k -> new ArrayList<>());
            graph.get(curr).add(prev);
        }
        traverseTree(curr.left, curr, graph, leafNodes);
        traverseTree(curr.right, curr, graph, leafNodes);
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();
        traverseTree(root, null, graph, leafNodes);
        int ans = 0;
        for(TreeNode leaf : leafNodes){
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            Set<TreeNode> seen = new HashSet<>();
            bfsQueue.add(leaf);
            seen.add(leaf);
            for(int i = 0; i <= distance; i++){
                int size = bfsQueue.size();
                while(size-- > 0){
                    TreeNode n = bfsQueue.poll();
                    if(leafNodes.contains(n) && n != leaf){
                        ans++;
                    }
                    if(graph.containsKey(n)){
                        for(TreeNode neigh : graph.get(n)){
                            if(!seen.contains(neigh)){
                                bfsQueue.offer(neigh);
                                seen.add(neigh);
                            }
                        }
                    }
                }
            }
        }
        return ans / 2;
    }
}