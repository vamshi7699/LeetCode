class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // to store the terminal state
        boolean[] terminal = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        
        // dfs on each unvisited node
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfs(graph, i, terminal, visited);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(terminal[i]){
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean dfs(int[][] graph, int currentNode, boolean[] terminal, boolean[] visited){
        // already calculated the terminal state, so return that
        if(visited[currentNode]){
            return terminal[currentNode];
        }
        
        visited[currentNode] = true;
        
        // no outgoing nodes, so terminal node
        if(graph[currentNode].length == 0){
            terminal[currentNode] = true;
            return true;
        }
        
        // term to check if each outgoing node is terminal or not
        boolean term = true;
        for(int neighbour: graph[currentNode]){
            // && checks for all to be true, so currentNode becomes terminal only if all neighbours are terminal 
            term = term && dfs(graph, neighbour, terminal, visited);
        }
        terminal[currentNode] = term;
        return terminal[currentNode];
    }
}
