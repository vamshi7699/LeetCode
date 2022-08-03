class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    res++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] a, boolean[][] v, int i, int j){
        if(i>=a.length || i<0 || j<0 || j>=a[0].length){
            return;
        }
        if(a[i][j]!='1' || v[i][j]){
            return;
        }
        v[i][j]=true;
        dfs(a,v,i-1,j);
        dfs(a,v,i+1,j);
        dfs(a,v,i,j-1);
        dfs(a,v,i,j+1);
    }
}
