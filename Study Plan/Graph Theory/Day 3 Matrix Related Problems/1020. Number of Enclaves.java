class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        
        // first mark all the islands that are on the edges (this are the one's where user can walk off)
        for(int i=0;i<n;i++){
            if(!visited[i][0] && grid[i][0] == 1){
                mark(grid, visited, i, 0);
            }
            
            if(!visited[i][m-1] && grid[i][m-1] == 1){
                mark(grid, visited, i, m-1);
            }
        }
        
        for(int j=0;j<m;j++){
            if(!visited[0][j] && grid[0][j] == 1){
                mark(grid, visited, 0, j);
            }
            
            if(!visited[n-1][j] && grid[n-1][j] == 1){
                mark(grid, visited, n-1, j);
            }
        }
        
        
        // all remaining points are internal and user cannot walkoff
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    res+=dfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }
    
    
    private int dfs(int[][] a, boolean[][] v, int i, int j){
        if(i>=a.length || i<0 || j<0 || j>=a[0].length){
            return 0;
        }
        if(a[i][j]!=1 || v[i][j]){
            return 0;
        }
        v[i][j]=true;
        int res = dfs(a,v,i-1,j);
        res += dfs(a,v,i+1,j);
        res += dfs(a,v,i,j-1);
        res += dfs(a,v,i,j+1);
        // since we already skip above if the current island is not 1, then this island is 1 and add to the result
        return 1 + res;
    }
    
    private void mark(int[][] a, boolean[][] v, int i, int j){
        if(i>=a.length || i<0 || j<0 || j>=a[0].length){
            return;
        }
        if(a[i][j]!=1 || v[i][j]){
            return;
        }
        v[i][j]=true;
        dfs(a,v,i-1,j);
        dfs(a,v,i+1,j);
        dfs(a,v,i,j-1);
        dfs(a,v,i,j+1);
    }
}
