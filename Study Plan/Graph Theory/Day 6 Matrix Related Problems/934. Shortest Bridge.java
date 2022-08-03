class Solution {
    
    int[][] dirs = new int[][] {{-1,0},{0,-1},{0,1},{1,0}};
    
    public int shortestBridge(int[][] a) {
        int n = a.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        
        // get any 1 that is part of the first island
        outer:
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(a[i][j] == 1){
                        q.add(new int[]{i,j,0});
                        vis[i][j]=true;
                        break outer;
                    }
                }
            }
        
        int min = Integer.MAX_VALUE;
        
        Queue<int[]> oneEdges = new LinkedList<>();
        
        // take all the 0's that are on the edges of the first island
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            // if 0 found, came out of first island
            // save this node
            if(a[curr[0]][curr[1]] == 0){
                oneEdges.add(new int[]{curr[0],curr[1],1});
                continue;
            }

            
            // add all valid neighbours
            for(int[] dir: dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && y>=0 && x<n && y<n && !vis[x][y]){
                    q.add(new int[]{x, y, 0});
                    vis[x][y]=true;
                }
            }
        }
        
        // start from the saved edge nodes of first island and start moving
        // If we reach the second island (1's which are not visited. All 1's in first island are marked visited)
        //      check if the bridge is minimum
        while(!oneEdges.isEmpty()){
            int[] curr = oneEdges.poll();
            
            // we only add non-visited to the queue
            // so this 1 will be of second island only
            if(a[curr[0]][curr[1]] == 1){
                min = Math.min(min, curr[2]);
                continue;
            }

            
            // add all valid neighbours
            for(int[] dir: dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && y>=0 && x<n && y<n && !vis[x][y]){
                    oneEdges.add(new int[]{x, y, a[x][y] == 0? curr[2] + 1 : curr[2]});
                    vis[x][y]=true;
                }
            }
        }
        
        return min; 
    }
}
