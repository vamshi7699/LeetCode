// Use BFS for the shortest solution requirement
class Solution {
    
    int[][] dirs = new int[][] {{-1,0},{0,-1},{0,1},{1,0}};
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        // add starting pos into queue
        q.add(new int[]{entrance[0], entrance[1], 0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            // if wall no need to move further
            if(maze[curr[0]][curr[1]] == '+'){
                continue;
            }
            
            if(vis[curr[0]][curr[1]]){
                continue;
            }
            
            // first part is edge condition and we should not consider the starting point (second part, for the case the starting point is on the edge)
            // since bfs we move in all directions at every step
            // if we reach and edge that means we reached at the lowest possible step
            if((curr[0] == 0 || curr[0] == n-1 || curr[1] == 0 || curr[1] == m-1) && !(curr[0] == entrance[0] && curr[1] == entrance[1])){
                return curr[2];
            }
            
            vis[curr[0]][curr[1]]=true;

            
            // add all valid neighbours
            for(int[] dir: dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && y>=0 && x<n && y<m){
                    q.add(new int[]{x, y, curr[2]+1});
                }
            }
        }
        return -1;
    }
}
