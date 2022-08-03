class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        
        // first mark all the islands that are on the edges (this are not surrounded by 1's)
        for(int i=0;i<n;i++){
            if(!visited[i][0] && grid[i][0] == 0){
                mark(grid, visited, i, 0);
            }
            
            if(!visited[i][m-1] && grid[i][m-1] == 0){
                mark(grid, visited, i, m-1);
            }
        }
        
        for(int j=0;j<m;j++){
            if(!visited[0][j] && grid[0][j] == 0){
                mark(grid, visited, 0, j);
            }
            
            if(!visited[n-1][j] && grid[n-1][j] == 0){
                mark(grid, visited, n-1, j);
            }
        }
        
        
        // all remaining one's can have surrounded 1's
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(!visited[i][j] && grid[i][j] == 0 && dfs(grid, visited, i, j)){
                    res++;
                }
            }
        }
        return res;
    }
    
    private boolean dfs(int[][] a, boolean[][] v, int i, int j){
        if(i>=a.length || i<0 || j<0 || j>=a[0].length){
            return true;
        }
        
        // since we already marked the islands that touch the edges this method is not called for any island such
        // so we can safely return true if v[i][j] or the index is at edges
        
        // we recursively try to find the next 1. If  found true
        if(a[i][j]==1 || v[i][j]){
            return true;
        }
        v[i][j]=true;
        
        // 1 should be there all sides, so &&
        boolean res = dfs(a,v,i-1,j);
        res = res && dfs(a,v,i+1,j);
        res = res && dfs(a,v,i,j-1);
        res = res && dfs(a,v,i,j+1);
        return res;
    }
    
    private void mark(int[][] a, boolean[][] v, int i, int j){
        if(i>=a.length || i<0 || j<0 || j>=a[0].length){
            return;
        }
        if(a[i][j]!=0 || v[i][j]){
            return;
        }
        v[i][j]=true;
        dfs(a,v,i-1,j);
        dfs(a,v,i+1,j);
        dfs(a,v,i,j-1);
        dfs(a,v,i,j+1);
    }
}
