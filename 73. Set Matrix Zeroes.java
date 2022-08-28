class Solution {
    public void setZeroes(int[][] a) {
        boolean col = false, row = false;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==0){
                    a[i][0]=0;
                    a[0][j]=0;
                    if(j==0) col = true;
                    if(i==0) row = true;
                }
            }
        }
        
              
        for(int i=1;i<a.length;i++){
            for(int j=1;j<a[0].length;j++){
                if(a[i][0]==0 || a[0][j]==0){
                    a[i][j]=0;
                }
            }
        }
        
        if(col){
            for(int i=0;i<a.length;i++){
                a[i][0]=0;
            }
        }
        
        if(row){
            for(int j=0;j<a[0].length;j++){
                a[0][j]=0;
            }
        }
    }
}
