class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth){
        if(node == null) return;
        if(result.size() == depth) result.add(node.val);

        dfs(node.right, depth+1);
        dfs(node.left, depth+1);
    }
}
