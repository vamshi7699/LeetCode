class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        
        
        // we can take each node with 1 value and do a dfs/bfs to find the nearest node
        // but this add more time complexity (each node might get visited multiple times)
        // so instead take the 0's and start moving in all directions
        // while moving increase the distance by 1 and mark in result array
        
        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new Point(i, j, 0));
                }
            }
        }
        
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.i<0 || p.j<0 || p.i>=grid.length || p.j>=grid[0].length){
                continue;
            }
            
            if(grid[p.i][p.j]==-1){
                continue;
            }
            
            res[p.i][p.j] = p.dist;
            
            grid[p.i][p.j] = -1;
            
            //q.add(new Point(p.i-1, p.j-1, 1+p.dist));
            q.add(new Point(p.i-1, p.j, 1+p.dist));
            //q.add(new Point(p.i-1, p.j+1, 1+p.dist));
            q.add(new Point(p.i, p.j-1, 1+p.dist));
            q.add(new Point(p.i, p.j+1, 1+p.dist));
            //q.add(new Point(p.i+1, p.j-1, 1+p.dist));
            q.add(new Point(p.i+1, p.j, 1+p.dist));
            //q.add(new Point(p.i+1, p.j+1, 1+p.dist));
        }
        
        return res;
    }
    
    class Point{
        int i,j,dist;
        Point(int x, int y, int z){
            i=x;j=y;dist=z;
        }
    }
}
