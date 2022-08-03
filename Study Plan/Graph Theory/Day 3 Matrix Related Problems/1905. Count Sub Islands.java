class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length, m = grid2[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] || grid2[i][j]==0){
                    continue;
                }
                
                // no 1 in grid1, so mark the entire connected island in grid2 visited
                if(grid2[i][j] !=  grid1[i][j]){
                    mark(grid2, visited, i, j);
                } else if(dfs(grid2, grid1, visited, i, j)) {
                    res++;
                } else {
                // subisland false, so mark this also
                    mark(grid2, visited, i, j);
                }
            }
        }
        
        return res;
    }
    
    private boolean dfs(int[][] a, int[][] b, boolean[][] v, int i, int j){
        if(i>=a.length || i<0 || j<0 || j>=a[0].length){
            return true;
        }
        if(a[i][j]!=1 || v[i][j]){
            return true;
        }
         
        
        // no island in first grid, so subisland false
        if(b[i][j] == 0){
            return false;
        }
        
        v[i][j]=true;
        
        boolean res = dfs(a,b,v,i-1,j);
        if(res)
            res = res && dfs(a,b,v,i+1,j);
        if(res)
            res = res && dfs(a,b,v,i,j-1);
        if(res)
            res = res && dfs(a,b,v,i,j+1);
        
        // if subisland false, marking visisted false so in parent method we can mark this entire grid2 island visited
        if(!res){
            v[i][j] = false;
        }
        
        return res;
    }
    
    private void mark(int[][] a, boolean[][] v, int i, int j){
        if(i>=a.length || i<0 || j<0 || j>=a[0].length){
            return;
        }
        if(a[i][j]!=1 || v[i][j]){
            return;
        }
        v[i][j]=true;
        mark(a,v,i-1,j);
        mark(a,v,i+1,j);
        mark(a,v,i,j-1);
        mark(a,v,i,j+1);
    }
}
