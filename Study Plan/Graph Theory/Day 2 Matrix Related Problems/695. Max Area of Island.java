class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, visited, i, j));
                }
            }
        }
        return max;
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
        return 1 + res;
    }
}
