class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms, 0, vis);
        boolean res = true;
        for(boolean room: vis){
            res = res && room;
        }
        return res;
    }
    
    public void dfs(List<List<Integer>> rooms, int currentNode, boolean[] vis){
        if(vis[currentNode]){
            return;
        }
        vis[currentNode] = true;
        
        for(int neighbour: rooms.get(currentNode)){
            dfs(rooms, neighbour, vis);
        }
    }
}
