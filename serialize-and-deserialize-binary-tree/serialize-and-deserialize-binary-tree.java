/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val+","+left+right;
    }
    
    private TreeNode helper(Queue<String> q){
        String str = q.poll();
        if(str.equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        return helper(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));