class Solution {
    
    int targetNode = 0;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        
        targetNode = graph.length-1;
        
        dfs(graph, 0, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(int[][] graph, int currentNode, List<List<Integer>> res, List<Integer> path){
        if(currentNode == targetNode){
            path.add(currentNode);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        
        path.add(currentNode);
        for(int neighbour: graph[currentNode]){
            dfs(graph, neighbour, res, path);
        }
        path.remove(path.size()-1);
    }
}
