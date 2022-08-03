class Solution {
    public int maxDistance(int[][] grid) {
        
        // we can take each node with 0 value and do a dfs/bfs to find the nearest 1 node
        // but this add more time complexity (each node might get visited multiple times)
        // so instead take the 1's and start moving in all directions
        // while moving increase the distance by 1 and mark if this is the maximum distance so far
        
        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.add(new Point(i, j, 0));
                }
            }
        }
        
        int max = 0;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.i<0 || p.j<0 || p.i>=grid.length || p.j>=grid[0].length){
                continue;
            }
            
            if(grid[p.i][p.j]==-1){
                continue;
            }
            
            max = Math.max(p.dist, max);
            
            grid[p.i][p.j] = -1;
            
            // Manhattan distance is basically the difference between X and Y coordiantes. So its like the distance we get when we move in the four directions
            q.add(new Point(p.i-1, p.j, 1+p.dist));
            q.add(new Point(p.i, p.j-1, 1+p.dist));
            q.add(new Point(p.i, p.j+1, 1+p.dist));
            q.add(new Point(p.i+1, p.j, 1+p.dist));
        }
        
        return max > 0 ? max : -1;
    }
    
    class Point{
        int i,j,dist;
        Point(int x, int y, int z){
            i=x;j=y;dist=z;
        }
    }
}
