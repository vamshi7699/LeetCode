// number of islands problem
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        
        boolean[] vis = new boolean[isConnected.length];
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                dfs(isConnected, i, vis);
                provinces++;
            }
        }
        return provinces;
    }
    
    public void dfs(int[][] isConnected, int currentNode, boolean[] vis){
        if(vis[currentNode]){
            return;
        }
        vis[currentNode] = true;
        
        for(int neighbour = 0; neighbour<isConnected[currentNode].length; neighbour++){
            if(isConnected[currentNode][neighbour] == 1){
                dfs(isConnected, neighbour, vis);   
            }
        }
    }
}
