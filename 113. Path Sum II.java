/**
 * Same as simple Path Sum that checks for exists path
 * but here we need all the paths, so just dont return once we find an path
 * keep checking for all the paths
 * 
 * and whenever we find a path, store that into the res
 *
 * to keep track of the path, have a list and add the elements in the path to the list
 * and clear that once we get back
 * add root
 * add left (root->left)
 * now if we have to calculate for the right side, we should not have the left node. So when we get back remove that node
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        getPaths(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    
    private void getPaths(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if(node == null){
            return;
        }
        
        path.add(node.val);
        
        if(targetSum == node.val && node.left == null && node.right==null) {
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        
        getPaths(node.left, targetSum-node.val, path, res);
        getPaths(node.right, targetSum-node.val, path, res);
        
        path.remove(path.size()-1);
    }
}
