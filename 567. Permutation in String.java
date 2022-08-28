class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        for(char x:s1.toCharArray()){
            a[x-97]++;
        }
                int s2len=s2.length(),s1len=s1.length();
        int i, j,p=s1len;

        for(i=0,j=0;j<s2len;){
            //System.out.println(i+" "+j+" "+p);
            
            if(a[s2.charAt(j)-97]==0){
                if(p==0)
                    return true;
                if(i!=j){
                    p++;
                    a[s2.charAt(i)-97]++;
                    i++;
                } else{
                    i++;
                    j++;
                }
            } else{
                p--;
                a[s2.charAt(j)-97]--;
                j++;
            }
        }
        //System.out.println(p);
        return p==0;
    }
}
